package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

class Parser {
    private static Map<String, Object> parserJSON(String fileData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileData, new TypeReference<>() {
        });
    }

    private static Map<String, Object> parserYAML(String fileData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(fileData, new TypeReference<>() {
        });
    }

    private static String getFileExtension(String filePath) {
        String[] arr = filePath.split("\\.");
        return arr[arr.length - 1];
    }

    public static Map<String, Object> parser(String fileData, String filePath) throws IOException {
        String extension = getFileExtension(filePath);

        return switch (extension) {
            case "json" -> parserJSON(fileData);
            case "yml" -> parserYAML(fileData);
            default -> throw new IOException("The '" + extension + "' file does not support.\n"
                    + "Only .json or .yml file are available");
        };
    }
}
