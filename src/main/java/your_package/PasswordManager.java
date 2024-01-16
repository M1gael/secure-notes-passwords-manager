import javax.swing.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordManager extends JFrame {

    private JTextField titleField;   //Assign private variables to the UI elements to be used in capturing and manipulation
    private JTextField contentArea;
    private JListView<String> noteListView;


    private void initSwingComponents(){ //initialise swing components in method
        titleField = new JTextField();
        contentArea = new JTextField();
        noteListView = new JList<>();

    }


    private void saveData(String title, String content) {
        Note newNote = new Note(title, content); // Create instance of note

        // For now, printing to console and adding to list view
        // Future: add to list or database
        System.out.println("Saved Note: " + newNote);
        noteListView.getItems().add(newNote.toString());
    }

    // ... (other methods)

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Manager");

        // Elements
        Label titleLabel = new Label("Title:");
        titleField = new TextField();  // Assign to class-level variable

        Label contentLabel = new Label("Content:");
        contentArea = new TextField(); // Use TextField for content input

        //onclick button event to capture data
        JButton saveNoteButton = new JButton("Save Note");
        saveNoteButton.setOnAction(e -> {
            String currentTitle = titleField.getText();
            String currentContent = contentArea.getText();

            saveData(currentTitle, currentContent);
        });

        noteListView = new ListView<>(); //initialize

        // Layout
        VBox layout = new VBox(15); // 10 pixel spacing
        layout.getChildren().addAll(titleLabel, titleField, contentLabel, contentArea, saveNoteButton , noteListView);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ... (other code)

    public static void main(String[] args) {
        launch(args);
    }
}
