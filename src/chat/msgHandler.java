package chat;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class msgHandler extends OutputStream{

    private JTextArea textArea;

    

    public msgHandler(JTextArea textArea) {
        this.textArea = textArea;
    }



    @Override
    public void write(int b) throws IOException {
        // TODO Auto-generated method stub
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.update(textArea.getGraphics());
    }

}
