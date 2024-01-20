import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManager extends JFrame {

    private JTextField titleField;
    String title = titleField.getText();
    private JTextField contentArea;
    String content = contentArea.getText();
    private DefaultListModel<String> noteListModel;
    private JList<String> noteListView;


    private void initSwingComponents() {
        // Set up JFrame
        JFrame mainFrame = new JFrame("Secure Notes");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create Layout Panel Using Gridlayout and Customise Elements
        JPanel uiLayout = new JPanel(new GridLayout(4, 2 , 15, 15 ));
             
        //Add Elements
        JLabel titleLabel = new JLabel("Title : ");
        JTextField titleField = new JTextField();
        
        JLabel contentLabel = new JLabel();
        JTextArea contentArea = new JTextArea();

        JButton saveButton = new JButton("Save Note");
        saveButton.addActionListener(new ActionEvent e {                       //current in Progress 

        });

        DefaultListModel<String> noteListModel = new DefaultListModel<>();
        JList<String> noteList = new JList<>(noteListModel);
    }

    private void saveData(String title, String content) {
        Note newNote = new Note(title, content);                //Eventually to be replaced by load note method in note class
        System.out.println("Saved Note: " + newNote);
        noteListModel.addElement(newNote.toString());
    }


    public static void main(String[] args) {

       
        
        //Create new JPanel centered using the FlowLayout
        
    
        

    }
}
