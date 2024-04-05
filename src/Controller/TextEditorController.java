package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.TextEditorModel;
import View.TextEditorView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TextEditorController {
    private TextEditorModel model;
    private TextEditorView view;

    public TextEditorController(TextEditorModel model) {
        this.model = model;
        this.view = new TextEditorView();
        attachEvents();
    }

    private void attachEvents() {
        view.getSaveMenuItem().setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            // Chọn loại tệp để lưu

            // chọn đuôi txt(Text)
            FileChooser.ExtensionFilter textFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");

            // chọn tất cả loại đuôi
            FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All Files (*.*)", "*.*");

            fileChooser.getExtensionFilters().addAll(textFilter, allFilter);

            // Mặc định chọn đuôi txt khi nhấn Save
            fileChooser.setSelectedExtensionFilter(textFilter);

            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                try {
                    // Lấy nội dung từ TextArea và chuyển thành List<String>
                    List<String> lines = Arrays.asList(view.getTextArea().getText().split("\\n"));
                    model.saveFile(file, lines);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Mở file bất kì trong thư mục
        view.getOpenMenuItem().setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                try {
                    model.loadFile(file);
                    view.getTextArea().setText(String.join("\n", model.getLines()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Tạo file mới
        view.getNewMenuItem().setOnAction(e -> {
            view.getTextArea().clear(); // Xóa nội dung hiện tại
            model.setLines(new ArrayList<>()); // Đặt lại textArea
        });
    }

    public TextEditorView getView() {
        return view;
    }
}
