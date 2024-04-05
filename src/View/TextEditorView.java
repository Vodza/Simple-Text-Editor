package View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class TextEditorView extends AnchorPane {
    private MenuBar menuBar;
    private TextArea textArea;
    private MenuItem saveMenuItem;
    private MenuItem openMenuItem;
    private MenuItem newMenuItem;

    public TextEditorView() {
        menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        newMenuItem = new MenuItem("New");
        openMenuItem = new MenuItem("Open");
        saveMenuItem = new MenuItem("Save");

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem);
        menuBar.getMenus().add(fileMenu);

        textArea = new TextArea();
        textArea.setLayoutY(25);
        textArea.setPrefSize(700, 300);

        this.getChildren().addAll(menuBar, textArea);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public MenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public MenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public MenuItem getNewMenuItem() {
        return newMenuItem;
    }
}
