package Joshua.principal;
import Joshua.parser.OperacionesLexer;
import Joshua.parser.OperacionesParser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
public class Principal extends Application{
    @FXML private Button boton1;
    @FXML private Button boton2;
    @FXML private TextArea text1;
    @FXML private TextArea salida_consola;
    @FXML private MenuItem menu1;
    @FXML private MenuItem menu2;
    @FXML private BorderPane border;
    private Stage primaryStage;
    private PrintStream flujo;
    public void start( Stage primaryStage ) throws IOException {







        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image image = new Image("j.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Compilador");
        primaryStage.setScene(new Scene(root,1500,1000));
       /* Consola datos =new Consola(salida_consola);


        flujo = new PrintStream(datos);

        */
        primaryStage.show();

    }

    /*public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            args = new String[]{"src/main/mu/test.mu"};
        }

        System.out.println("parsing: " + args[0]);

        OperacionesLexer lexer = new OperacionesLexer(new ANTLRFileStream(args[0]));
        OperacionesParser parser = new OperacionesParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }




     */
    public void traducir(ActionEvent event)
    {
        ArrayList<String> str = new ArrayList<String>();
        String code = "";
        String code2 = "";
        String code3 = "";
        code= text1.getText();
        char[] codificador=code.toCharArray();
        for (int i = 0; i < codificador.length; i++)
        {
            if(codificador[i]=='{'||codificador[i]=='}'||codificador[i]=='('||codificador[i]==')'||codificador[i]==';'||codificador[i]=='\n'||codificador[i]==' ')
            {
                if(code2=="")
                {
                    code3.valueOf(codificador[i]);
                    str.add(code3);
                }
                str.add(code2);
                code2="";
            }
            code2=code2+codificador[i];
        }
        String a="";
        for (int i = 0; i < str.size(); i++)
        {
            if(str.get(i).contains(""+"printf"))
            {
                str.set(i,"\nimprimir");
            }
            if(str.get(i).contains("#include"))
            {
                str.set(i,"");
            }
            if(str.get(i).contains(""+"<stdio.h>"))
            {
                str.set(i," ");
            }
            if(str.get(i).contains(""+"while"))
            {
                str.set(i,"\nmientras");
            }
            if(str.get(i).contains(""+"int"))
            {
                str.set(i,"\npit");
            }
            if(str.get(i).contains(""+"float"))
            {
                str.set(i,"\npit");
            }
            if(str.get(i).contains(""+"if"))
            {
                str.set(i,"\nsi");
            }
            if(str.get(i).contains(""+"else"))
            {
                str.set(i,"\nsino");
            }
            if(str.get(i).contains(""+"main"))
            {
                str.set(i,"\nprogra");
            }
            if(str.get(i).contains(""+"void"))
            {
                str.set(i,"");
            }
            a=a+str.get(i);
        }
        text1.setText(a+"\n}");
    }
    public void destraducir(ActionEvent event)
    {
        ArrayList<String> str = new ArrayList<String>();
        String code = "";
        String code2 = "";
        String code3 = "";
        code= text1.getText();
        char[] codificador=code.toCharArray();




        for (int i = 0; i < codificador.length; i++)
        {

            if(codificador[i]=='{'||codificador[i]=='}'||codificador[i]=='('||codificador[i]==')'||codificador[i]==';'||codificador[i]=='\n'||codificador[i]==' ')
            {
                if(code2=="")
                {
                    code3.valueOf(codificador[i]);
                    str.add(code3);
                }
                str.add(code2);
                code2="";
            }
            code2=code2+codificador[i];
        }


        String a="#include <stdio.h> ";
        for (int i = 0; i < str.size(); i++)
        {

            if(str.get(i).contains(""+"imprimir"))
            {
                str.set(i,"\nprintf");
            }
            if(str.get(i).contains(""+"mientras"))
            {
                str.set(i,"\nwhile");
            }
            if(str.get(i).contains(""+"entero"))
            {
                str.set(i,"\nint");
            }
            if(str.get(i).contains(""+"si"))
            {
                str.set(i,"\nif");
            }
            if(str.get(i).contains(""+"sino"))
            {
                str.set(i,"\nelse");
            }
            if(str.get(i).contains(""+"progra"))
            {
                str.set(i,"\nmain");
            }
            if(str.get(i).contains(""+"void"))
            {
                str.set(i,"");
            }
            a=a+str.get(i);
        }

        text1.setText(a+"\n}");
    }

    public void compilar(ActionEvent event) throws IOException
    {
       /* System.setOut(flujo);

        */
        File file = new File("data.txt");
        SaveFile(text1.getText(), file);
        CharStream input = null;
        try {
            input = CharStreams.fromFileName("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }



        String[] lines = input.toString().split("\r\n|\r\n");
        for(String i:lines){
            OperacionesLexer lexer = new OperacionesLexer(CharStreams.fromString(i));
            OperacionesParser parser = new OperacionesParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.parse();
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);
            try {
                BufferedReader lector = new BufferedReader(new FileReader("resultado.txt"));
                StringBuilder cadena = new StringBuilder();
                String line = null;
                while ((line = lector.readLine()) != null) {
                    cadena.append(line+"\n");
                }
                lector.close();
                String contenido = cadena.toString();
                salida_consola.setText(contenido);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        }


        try {
            FileWriter fileWriter = new FileWriter("resultado.txt");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException ex) {

        }


    }
    public void borrar(ActionEvent event) throws IOException
    {
        salida_consola.setText(" ");
    }
    public void abrir(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        stage.setTitle("Calculadora");
        File file = fileChooser.showOpenDialog(stage);
        try {
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder cadena = new StringBuilder();
            String line = null;

            while ((line = lector.readLine()) != null) {
                cadena.append(line+"\n");

            }
            lector.close();
            String contenido = cadena.toString();
            text1.setText(contenido);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
    public void cerrar(ActionEvent event) throws IOException
    {
        System.exit(0);
    }
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {

        }

    }
   /* public class Consola  extends OutputStream{
      private TextArea salida_consola;
      public Consola(TextArea salida_consola){
          this.salida_consola=salida_consola;
      }

      public void adjuntarTexto(String caracteres){
          Platform.runLater(()->
                  salida_consola.appendText(caracteres));
      }
      public void write(int b){adjuntarTexto(String.valueOf((char)b));}

    }

    */
    public static void main(String[] args)throws Exception
    {
        launch(args);







    }





}
