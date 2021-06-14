package Joshua.exceptions;

public class ExceptionErrorDeclarar extends Exception{
    public static final String  ANSI_REESET="\u001B[0M";
    public static final String ANSI_RED="\u001B[31m";

    public ExceptionErrorDeclarar(String s){ System.out.println(ANSI_RED+s+ANSI_REESET);}
}
