package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextEditorModel {
    private List<String> lines = new ArrayList<>();

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void loadFile(File file) throws IOException {
        lines = Files.lines(Paths.get(file.toURI())).collect(Collectors.toList());
    }

    public void saveFile(File file, List<String> lines) throws IOException {
        Files.write(Paths.get(file.toURI()), lines);
    }

    // Đệ quy
    public void traverseDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    traverseDirectory(file);
                } else {
                    // Xử lý file
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}