package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

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
        String[] Arr = filePath.split("\\.");
        return Arr[2];
    }

    public static Map<String, Object> parser(String fileData, String filePath) throws JsonProcessingException {
        String extension = getFileExtension(filePath);
        if (extension.equals("json")) {
            return parserJSON(fileData);
        }
        return parserYAML(fileData);
    }
}
