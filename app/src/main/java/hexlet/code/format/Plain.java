package hexlet.code.format;

import hexlet.code.Element;
import hexlet.code.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Plain {

    private static boolean isComplex(Object value) {
        return value instanceof Arrays || value instanceof List || value instanceof Map<?, ?>;
    }

    private static boolean isString(Object value) {
        return value instanceof String;
    }

    public static String plain(List<Element> formedList) {
        final String[] result = {""};

        formedList
                .stream()
                .filter(x -> !x.getStatus().equals(Status.unchanged))
                .forEach(x -> {
                    String update = "";
                    String added = "";

                    if (isString(x.getValueFirstMap())) {
                        x.setValueFirstMap("'" + x.getValueFirstMap() + "'");
                    }
                    if (isString(x.getValueSecondMap())) {
                        x.setValueSecondMap("'" + x.getValueSecondMap() + "'");
                    }
                    if (isComplex(x.getValueFirstMap())) {
                        x.setValueFirstMap("[complex value]");
                    }
                    if (isComplex(x.getValueSecondMap())) {
                        x.setValueSecondMap("[complex value]");
                    }
                    if (x.getStatus().equals(Status.updated)) {
                        update += ". From " + x.getValueFirstMap() + " to " + x.getValueSecondMap();
                    }
                    if (x.getStatus().equals(Status.added)) {
                        added += " with value: " + x.getValueSecondMap();
                    }

                    result[0] += "\nProperty '" + x.getName() + "' was " + x.getStatus() + update + added;
                }
            );
        return result[0].trim();
    }
}
