import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManager extends JFrame {

    private JTextField titleField;
    private JTextField contentArea;
    private DefaultListModel<String> noteListModel;
    private JList<String> noteListView;

    private void initSwingComponents() {
        titleField = new JTextField();
        contentArea = new JTextField();
        noteListModel = new DefaultListModel<>();
        noteListView = new JList<>(noteListModel);

        titleField.setPreferredSize(new Dimension(200 , 30));
        contentArea.setPreferredSize(new Dimension(200 , 30));
    }

    private void saveData(String title, String content) {
        Note newNote = new Note(title, content);
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

        // Layout
        JPanel layout = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        layout.add(titleLabel);
        layout.add(titleField);
        layout.add(contentArea);
        layout.add(saveNoteButton);
        layout.add(new JScrollPane(noteListView)); // Use JScrollPane for the list

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
