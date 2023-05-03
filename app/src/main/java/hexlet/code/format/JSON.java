package hexlet.code.format;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
    public static String json(List<Object> formedList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> outMap = new TreeMap<>();

        formedList
                .stream()
                .filter(x -> !x.toString().startsWith("unchanged"))
                .forEach(x -> {
                    String[] arr = x.toString().split("%");

                    String key = arr[1];
                    String value = arr[0];

                    outMap.put(key, value);
                });

        return mapper.writeValueAsString(outMap);
    }
}
