import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void workTestSimpleJSON() throws Exception {
        String fileOne = "./src/test/resources/simpleJSON/file1.json";
        String fileTwo = "./src/test/resources/simpleJSON/file2.json";
        String rightFile = "./src/test/resources/rightFile/simple.txt";
        Path rightFilePath = Paths.get(rightFile).toAbsolutePath().normalize();

        String actual = Differ.generate(fileOne, fileTwo);
        String expected = Files.readString(rightFilePath).trim();
        assertEquals(expected, actual);
    }

    @Test
    public void workTestSimpleYML() throws Exception {
        String fileOne = "./src/test/resources/simpleYML/file1.yml";
        String fileTwo = "./src/test/resources/simpleYML/file2.yml";
        String rightFile = "./src/test/resources/rightFile/simple.txt";
        Path rightFilePath = Paths.get(rightFile).toAbsolutePath().normalize();

        String actual = Differ.generate(fileOne, fileTwo);
        String expected = Files.readString(rightFilePath).trim();
        assertEquals(expected, actual);
    }

    @Test
    public void workTestInner() throws Exception {
        String fileOne = "./src/test/resources/innerJSON/file1.json";
        String fileTwo = "./src/test/resources/innerJSON/file2.json";
        String rightFile = "./src/test/resources/rightFile/inner.txt";
        Path rightFilePath = Paths.get(rightFile).toAbsolutePath().normalize();

        String actual = Differ.generate(fileOne, fileTwo);
        String expected = Files.readString(rightFilePath).trim();
        assertEquals(expected, actual);
    }
    @Test
    public void workTestFormatStyle() throws Exception {
        String stylish = "stylish";
        String plain = "plain";
        String json = "json";

        String fileOne = "./src/test/resources/simpleJSON/file1.json";
        String fileTwo = "./src/test/resources/simpleJSON/file2.json";

        String rightFileStylish = "./src/test/resources/rightFile/simple.txt";
        String rightFilePlain = "./src/test/resources/rightFile/plain.txt";
        String rightFileJSON = "./src/test/resources/rightFile/json_out.txt";

        Path rightFilePathStylish = Paths.get(rightFileStylish).toAbsolutePath().normalize();
        Path rightFilePathPlain = Paths.get(rightFilePlain).toAbsolutePath().normalize();
        Path rightFilePathJSON = Paths.get(rightFileJSON).toAbsolutePath().normalize();

        String actualStylish = Differ.generate(fileOne, fileTwo, stylish);
        String actualPlain = Differ.generate(fileOne, fileTwo, plain);
        String actualJSON = Differ.generate(fileOne, fileTwo, json);

        String expectedStylish = Files.readString(rightFilePathStylish).trim();
        String expectedPlain = Files.readString(rightFilePathPlain).trim();
        String expectedJSON = Files.readString(rightFilePathJSON).trim();

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJSON, actualJSON);
    }
}
