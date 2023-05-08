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

    private static String statusLowerCase(Object status) {
        return status.toString().toLowerCase();
    }

    public static String plain(List<Element> formedList) {
        final String[] result = {""};

        formedList
                .stream()
                .filter(x -> !x.getStatus().equals(Status.UNCHANGED))
                .forEach(x -> {
                    String update = "";
                    String added = "";
                    Object valueFirst = x.getValueFirstMap();
                    Object valueSecond = x.getValueSecondMap();

                    if (isString(x.getValueFirstMap())) {
                        valueFirst = "'" + x.getValueFirstMap() + "'";
                    } else if (isComplex(x.getValueFirstMap())) {
                        valueFirst = "[complex value]";
                    }
                    if (isString(x.getValueSecondMap())) {
                        valueSecond = "'" + x.getValueSecondMap() + "'";
                    } else if (isComplex(x.getValueSecondMap())) {
                        valueSecond = "[complex value]";
                    }

                    if (x.getStatus().equals(Status.UPDATED)) {
                        update += ". From " + valueFirst + " to " + valueSecond;
                    }
                    if (x.getStatus().equals(Status.ADDED)) {
                        added += " with value: " + valueSecond;
                    }
                    result[0] += "\nProperty '" + x.getName() + "' was " + statusLowerCase(x.getStatus())
                            + update + added;
                }
            );
        return result[0].trim();
    }
}
