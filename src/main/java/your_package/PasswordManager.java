import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordManager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Manager");

        //Elements
        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();

        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();

        Button saveButton = new Button("Save");
        
        //Layout
        VBox layout = new VBox(15); //10 [pixel spacing]
        layout.getChildren().addAll(nameLabel , nameField , passwordLabel , passwordField , saveButton);
        
        Scene scene = new Scene( layout , 400 , 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}
