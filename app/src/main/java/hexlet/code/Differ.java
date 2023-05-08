package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.List;
import java.util.Map;

public class Differ {
    private static Path getAbsolutePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    private static String getDataFromFile(Path absoluteFilePath) throws Exception {
        return Files.readString(absoluteFilePath);
    }

    private static void checkFileExistence(Path absoluteFilePath) throws IOException {
        if (!Files.exists(absoluteFilePath)) {
            throw new IOException("'" + absoluteFilePath + "' does not exist.\nCheck the file or it's extension.");
        }
    }

    private static Map<String, Object> getData(String filePath) throws Exception {
        Path fileAbsolutePath = getAbsolutePath(filePath);
        checkFileExistence(fileAbsolutePath);
        String fileData = getDataFromFile(fileAbsolutePath);
        return Parser.parser(fileData, filePath);
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {

        Map<String, Object> content1 = getData(filePath1);
        Map<String, Object> content2 = getData(filePath2);

        List<Element> formedList = StatusFormer.getStatus(content1, content2);

        return Formatter.format(formedList, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {

        return generate(filePath1, filePath2, "stylish");
    }
}
