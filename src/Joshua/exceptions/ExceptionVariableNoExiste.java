package Joshua.exceptions;

import javax.swing.*;

public class ExceptionVariableNoExiste extends RuntimeException{
    public ExceptionVariableNoExiste(String id)
    {

        JOptionPane.showMessageDialog(null, "Variable '"+id+"' no existe",  "Error", JOptionPane.INFORMATION_MESSAGE);

    }
}
