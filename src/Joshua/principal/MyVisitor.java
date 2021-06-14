package Joshua.principal;
import Joshua.exceptions.ExceptionDeclaradoDoble;
import Joshua.exceptions.ExceptionVariableNoExiste;
import Joshua.parser.OperacionesBaseVisitor;
import Joshua.parser.OperacionesParser;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.antlr.v4.runtime.misc.NotNull;
import java.io.*;
import java.util.*;

class EvalVisitor extends OperacionesBaseVisitor<Value> {
    @FXML private TextArea text2;

    public static final double SMALL_VALUE = 0.00000000001;


    private final Stack<Integer> pila=new Stack();
    private final Map<Integer,LinkedHashMap<String,Value>> memoria_memorias=new HashMap();
    private final LinkedHashMap<String, Value> memoria = new LinkedHashMap<>();
    private LinkedHashMap<String,Value> memoria_size = new LinkedHashMap<>();
    private int level = 0;


    @Override
    public Value visitAssignment(OperacionesParser.AssignmentContext ctx) {

        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());
        return memoria.put(id, value);
    }
    @Override
    public Value visitAsignacion(OperacionesParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        if(memoria.containsKey(id)) {
             throw new ExceptionDeclaradoDoble();
        }
        if(ctx.expr()==null) {

            return memoria.put(id, null);
        }
        else{
            Value value = this.visit(ctx.expr());
            return memoria.put(id, value);
        }
    }
    public static <K,V> LinkedHashMap<String,Value>clonar(Map<String,Value>original)
    {
        return new LinkedHashMap<>(original);
    }
    @Override public Value visitLlave_A(OperacionesParser.Llave_AContext ctx) {
        memoria_size = clonar(memoria);
        int size_bloque=memoria_size.size();
        pila.push(size_bloque);
        memoria_memorias.put(level,memoria);
        level++;
        return Value.VOID;
    }
    @Override public Value visitLlave_C(OperacionesParser.Llave_CContext ctx) {
        int size_actual=memoria.size();
        int size = size_actual -pila.pop();
        Set<Map.Entry<String,Value>> entradas=memoria.entrySet();
        Iterator<Map.Entry<String,Value>> iterator=entradas.iterator();
        Map.Entry<String,Value>entry,lastEntry=null;
        for(int i=0;i<size;i++)
        {
            while(iterator.hasNext()){
                entry=iterator.next();
                lastEntry=entry;
            }
            memoria.remove(lastEntry.getKey());
        }
        level--;
        return Value.VOID;
    }
    @Override
    public Value visitIdAtom(OperacionesParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value = memoria.get(id);
        if(value == null) {
            throw new ExceptionVariableNoExiste(id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(OperacionesParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(OperacionesParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(OperacionesParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));

    }


    @Override
    public Value visitNilAtom(OperacionesParser.NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(OperacionesParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(OperacionesParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(OperacionesParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(OperacionesParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull OperacionesParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        switch (ctx.op.getType()) {
            case OperacionesParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case OperacionesParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case OperacionesParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + OperacionesParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAdditiveExpr(@NotNull OperacionesParser.AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case OperacionesParser.PLUS:
                return left.isDouble() && right.isDouble() ?
                        new Value(left.asDouble() + right.asDouble()) :
                        new Value(left.asString() + right.asString());
            case OperacionesParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + OperacionesParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitRelationalExpr(@NotNull OperacionesParser.RelationalExprContext ctx) {

        Value izq = this.visit(ctx.expr(0));
        Value der = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case OperacionesParser.LT:
                return new Value(izq.asDouble() < der.asDouble());
            case OperacionesParser.LTEQ:
                return new Value(izq.asDouble() <= der.asDouble());
            case OperacionesParser.GT:
                return new Value(izq.asDouble() > der.asDouble());
            case OperacionesParser.GTEQ:
                return new Value(izq.asDouble() >= der.asDouble());
            default:
                throw new RuntimeException("No se reconoce el simbolo: " + OperacionesParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitEqualityExpr(@NotNull OperacionesParser.EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        System.out.println(left);
        System.out.println(right);
        switch (ctx.op.getType()) {
            case OperacionesParser.EQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                        new Value(left.equals(right));
            case OperacionesParser.NEQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                        new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + OperacionesParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(OperacionesParser.AndExprContext ctx) {
        Value izq = this.visit(ctx.expr(0));
        Value der = this.visit(ctx.expr(1));
        return new Value(izq.asBoolean() && der.asBoolean());
    }

    @Override
    public Value visitOrExpr(OperacionesParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    String a="";
    @Override
    public Value visitLog(OperacionesParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());

        if(value==null)
        {
            throw new ExceptionDeclaradoDoble();
        }

        a = (a + value + "\n");
        System.out.println(a);
        try {
            FileWriter fileWriter = new FileWriter("resultado.txt");
            fileWriter.write(a);
            fileWriter.close();
        } catch (IOException ex) {

        }

        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(OperacionesParser.If_statContext ctx) {

        List<OperacionesParser.Condition_blockContext> conditions =  ctx.condition_block();

        boolean evaluatedBlock = false;

        for(OperacionesParser.Condition_blockContext condition : conditions) {

            Value evaluated = this.visit(condition.expr());

            if(evaluated.asBoolean()) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block());
                break;
            }
        }

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(OperacionesParser.While_statContext ctx) {

        Value value = this.visit(ctx.expr());

        while(value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }
}
