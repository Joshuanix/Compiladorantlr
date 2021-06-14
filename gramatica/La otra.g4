grammar Operaciones;
inicio2: inicio+;
inicio :
            expr        #impresionExpresion
            |
            ENTERO ID IGUAL expr    #asignacion
            |
            ID IGUAL expr            #igualacion
            |
            PC              #espacio
            ;

 expr:
            expr op=(POR | DIV) expr          #MulDiv
            |
            expr op=(MAS | MENOS) expr      #SumRes
            |
            INT                          #int
            |
            ID                           #id
            |
            PAR_A expr PAR_C             #parentesis
            ;
 ID: [a-z][a-zA-Z0-9]+;
 IGUAL: '=';
 POR:'*';
 DIV:'/';
 MAS:'+';
 MENOS:'-';
 INT:[0-9]+;
 PAR_A:'(';
 PAR_C:')';
 ESPACIOS:[ \t\r\n] -> skip;