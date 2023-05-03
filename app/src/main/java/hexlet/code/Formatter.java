package hexlet.code;

import hexlet.code.format.JSON;
import hexlet.code.format.Plain;
import hexlet.code.format.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> content1, Map<String, Object> content2, String formatName)
            throws IOException {
        List<Object> formedList = StatusFormer.getStatus(content1, content2);

        if (formatName.equals("json")) {
            return JSON.json(formedList);
        }

        if (formatName.equals("plain")) {
            return Plain.plain(formedList);
        }
        return Stylish.stylish(formedList);
    }
}
