package Joshua.exceptions;

import javax.swing.*;

public class ExceptionDeclaradoDoble extends RuntimeException{
    public ExceptionDeclaradoDoble()
    {

            JOptionPane.showMessageDialog(null, "Declarado Doble", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

    }
}
