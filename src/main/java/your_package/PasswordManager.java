import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordManager extends Application {

    private void saveData(String title, String content) {
        Note newNote = new Note(title, content); // Create instance of note

        // For now, printing to console and adding to list view
        // Future: add to list or database
        System.out.println("Saved Note: " + newNote);

        // Update UI - add the note to the ListView
        noteList.getItems().add(newNote.toString());

        // Alert successful saving
        showAlert("Note saved successfully");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Manager");

        // Elements
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label contentLabel = new Label("Content:");
        TextField contentArea = new TextField(); // Use TextField for content input

        Button saveNoteButton = new Button("Save Note");

        // Layout
        VBox layout = new VBox(15); // 10 pixel spacing
        layout.getChildren().addAll(titleLabel, titleField, contentLabel, contentArea, saveNoteButton);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
