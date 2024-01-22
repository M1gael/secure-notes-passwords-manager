import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManager extends JFrame {
                                    //Creates a private instance of ex: JLabel named titleLabel
    private JLabel titleLabel;      //Title
    private JTextField titleField;
    private JLabel contentLabel;    //Content
    private JButton saveNoteButton ;     //Save 
    private JTextField contentArea;
    private DefaultListModel<String> noteListModel; //Display
    private JList<String> noteListView;

    private void initSwingComponents() {
        titleLabel = new JLabel("Title: ");    //Said instance is assigned values
        titleField = new JTextField();

        contentLabel = new JLabel("Content: ");
        contentArea = new JTextField();

        saveNoteButton = new JButton("Save");
        saveNoteButton.addActionListener(new ActionListener() { //Event handling with ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTitle = titleField.getText();
                String currentContent = contentArea.getText();
                saveData(currentTitle, currentContent);
            }
        });

        noteListModel = new DefaultListModel<>();
        noteListView = new JList<>(noteListModel);

        titleField.setPreferredSize(new Dimension(50 , 30));
        contentArea.setPreferredSize(new Dimension(200 , 30));
        noteListView.setPreferredSize(new Dimension(400 , 400));
    }

    private void saveData(String title, String content) {
        Note newNote = new Note(title, content);
        System.out.println("Saved Note: " + newNote);
        noteListModel.addElement(newNote.toString());
    }

    public PasswordManager() {
        initSwingComponents();

        // Layout using GridLayout                //4 Rows , 2 Columns , ??? ,???
        JPanel layout = new JPanel(new GridLayout(4, 3 , 15, 15 ));
        
        layout.add(titleLabel); //Title
        titleField.setPreferredSize(new Dimension(150 , 25));
        layout.add(titleField);

        layout.add(new JLabel("Content:")); //Content
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
        SwingUtilities.invokeLater(() -> {
            PasswordManager passwordManager = new PasswordManager();
            passwordManager.setVisible(true);
        });
    }
}
