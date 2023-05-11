package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
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

    public static Map<String, Object> parser(String fileData, String fileExtension) throws IOException {

        return switch (fileExtension) {
            case "json" -> parserJSON(fileData);
            case "yml", "yaml" -> parserYAML(fileData);
            default -> throw new IOException("The '" + fileExtension + "' file does not support.\n"
                    + "Only .json or .ymal/.yml file are available");
        };
    }
}
