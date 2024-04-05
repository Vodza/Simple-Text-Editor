
// Main.java
import Controller.TextEditorController;
import Model.TextEditorModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextEditorController controller = new TextEditorController(new TextEditorModel());
        Scene scene = new Scene(controller.getView(), 700, 300);
        primaryStage.setTitle("Simple Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
