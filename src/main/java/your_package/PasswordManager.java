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


    private static void initSwingComponents() {
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
       /*  saveButton.addActionListener(new ActionEvent e {                       //current in Progress 

        }); */

        DefaultListModel<String> noteListModel = new DefaultListModel<>();
        JList<String> noteList = new JList<>(noteListModel);
    
        //add elements
        mainFrame.add(uiLayout);
        mainFrame.add(titleField);


    }

    private void saveData(String title, String content) {
        Note newNote = new Note(title, content);                //Eventually to be replaced by load note method in note class
        System.out.println("Saved Note: " + newNote);
        noteListModel.addElement(newNote.toString());
    }

    public PasswordManager() {
        initSwingComponents();

        // Elements
        JLabel titleLabel = new JLabel("Title:");

        JButton saveNoteButton = new JButton("Save Note");
        saveNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTitle = titleField.getText();
                String currentContent = contentArea.getText();
                saveData(currentTitle, currentContent);
            }
        });

        // Layout using GridLayout
        JPanel layout = new JPanel(new GridLayout(4, 2 , 15, 15 ));
        layout.add(titleLabel);
        titleField.setPreferredSize(new Dimension(150 , 25));
        layout.add(titleField);
        layout.add(new JLabel("Content:"));
        contentArea.setPreferredSize(new Dimension(200,200));
        layout.add(contentArea);
        layout.add(saveNoteButton);
        layout.add(new JLabel());  //Empty cell for spacing
        layout.add(new JScrollPane(noteListView)); // Use JScrollPane for the list
        layout.add(new JLabel());
        

        // Set up JFrame
        setTitle("Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(layout);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        initSwingComponents();

        
        //Create new JPanel centered using the FlowLayout
        
    
        

    }
}
