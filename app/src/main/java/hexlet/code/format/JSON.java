package hexlet.code.format;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Element;

public class JSON {
    public static String json(List<Element> formedList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(formedList);
    }
}
