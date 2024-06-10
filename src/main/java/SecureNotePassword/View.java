package src.main.java.SecureNotePassword;

import javax.swing.JFrame;

public class View extends JFrame{

    //Display Login
    public void displayLogin(){
        JFrame frame = new JFrame("Login");
        frame.setSize(500 , 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
