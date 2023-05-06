import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private static String expectedStylish;

    private static String expectedPlain;

    private static String expectedJSON;

    private static Path getAbsolutePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    private static String pathToString(Path absoluteFilePath) throws Exception {
        return Files.readString(absoluteFilePath).trim();
    }

    @BeforeAll
    public static void expectedAnswer() throws Exception {
        String rightFileStylish = "./src/test/resources/rightFile/expected_stylish.txt";
        String rightFilePlain = "./src/test/resources/rightFile/expected_plain.txt";
        String rightFileJSON = "./src/test/resources/rightFile/expected_json.json";

        expectedStylish = pathToString(getAbsolutePath(rightFileStylish));
        expectedPlain = pathToString(getAbsolutePath(rightFilePlain));
        expectedJSON = pathToString(getAbsolutePath(rightFileJSON));
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public void workTestFormatStyle(String extension) throws Exception {
        String stylish = "stylish";
        String plain = "plain";
        String json = "json";

        String fileOne = "./src/test/resources/" + extension + "/file1." + extension;
        String fileTwo = "./src/test/resources/" + extension + "/file2." + extension;

        String actualDefault = Differ.generate(fileOne, fileTwo);
        String actualStylish = Differ.generate(fileOne, fileTwo, stylish);
        String actualPlain = Differ.generate(fileOne, fileTwo, plain);
        String actualJSON = Differ.generate(fileOne, fileTwo, json);

        assertEquals(expectedStylish, actualDefault);
        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJSON, actualJSON);
    }
}
