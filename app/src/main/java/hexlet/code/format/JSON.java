package hexlet.code.format;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Element;
import hexlet.code.Status;

public class JSON {
    public static String json(List<Element> formedList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> outMap = new TreeMap<>();

        formedList
                .stream()
                .filter(x -> !x.getStatus().equals(Status.unchanged))
                .forEach(x -> {

                    String key = x.getName();
                    String value = x.getStatus().toString();

                    outMap.put(key, value);
                });

        return mapper.writeValueAsString(outMap);
    }
}
