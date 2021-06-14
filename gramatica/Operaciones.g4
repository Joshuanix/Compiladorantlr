grammar Operaciones;

parse
 :PR llave_A block llave_C
 ;
llave_A:
OBRACE;
llave_C:
CBRACE;
block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | log
 | asignacion

 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;
asignacion
 : ENTERO ID ASSIGN? expr? SCOL
 ;
assignment
 : ID ASSIGN expr SCOL
 ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : llave_A block llave_C
 | stat
 ;

while_stat
 : WHILE expr stat_block
 ;

log
 : LOG expr SCOL
 ;

expr
 : expr POW<assoc=right> expr           #powExpr
 | MINUS expr                           #unaryMinusExpr
 | NOT expr                             #notExpr
 | expr op=(MULT | DIV | MOD) expr      #multiplicationExpr
 | expr op=(PLUS | MINUS) expr          #additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr #relationalExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | atom                                 #atomExpr


 ;

atom
 : OPAR expr CPAR #parExpr
 | (INT | FLOAT)  #numberAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NIL            #nilAtom
 | (TRUE | FALSE) #booleanAtom
 ;


PR:'progra()';
OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';
ENTERO:'pit';
SCOL : ';';
ASSIGN : '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

TRUE : 'true';
FALSE : 'false';
NIL : 'nil';
IF : 'si';
ELSE : 'sino';
WHILE : 'mientras';
LOG : 'imprimir';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]*
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : ( '//' ~[\r\n]* | '/*' .*? '*/' ) -> skip
 ;
SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : .
 ;
