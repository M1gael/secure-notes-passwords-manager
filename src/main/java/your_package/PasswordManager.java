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
        
        //Set up JFrame
        setTitle("Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setBackground(Color.red);                   //Does not work
        setLocationRelativeTo(null);
        
        //Set frame Layout 
        setLayout(new FlowLayout());

        //Set Panel for UI Elements
        JPanel holdElementsPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        holdElementsPnl.setSize(600 , 600);
        holdElementsPnl.setBackground(Color.blue);      //last worked on
        add(holdElementsPnl);
        
        //Add UI Elements to pnl
        holdElementsPnl.add(titleField);
        holdElementsPnl.add(contentArea);
        holdElementsPnl.add(saveNoteButton);
        holdElementsPnl.add(noteListView);

        //Add Panel to Mainframe
        add(holdElementsPnl);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordManager passwordManager = new PasswordManager();
            passwordManager.setVisible(true);
        });
    }
}
/*     
 // Set up JFrame                    //Works because of "extends JFrame"??
        setTitle("Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(800, 900);
        setLocationRelativeTo(null);

        // Layout using GridLayout                              //4 Rows , 2 Columns , ??? ,???
        JPanel layout = new JPanel(new FlowLayout());      //or    new GridLayout(4 , 2, 15, 15 )
        setContentPane(layout);
        //Title
        titleField.setPreferredSize(new Dimension(150 , 25));
        layout.add(titleField);

        //Content
        contentArea.setPreferredSize(new Dimension(200,200));
        layout.add(contentArea);

        layout.add(saveNoteButton);
        
        layout.add(new JLabel());                           //Empty cell for spacing
        
        layout.add(new JScrollPane(noteListView));           // Use JScrollPane for the list
        
        layout.add(new JLabel());
        

 */