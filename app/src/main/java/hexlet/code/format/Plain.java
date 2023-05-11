package hexlet.code.format;

import hexlet.code.KeyDiff;
import hexlet.code.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {

    private static Object complexToString(Object value) {
        return value instanceof Arrays || value instanceof List || value instanceof Map<?, ?>
                ? "[complex value]" : value;
    }

    private static Object stringToDecor(Object value) {
        return value instanceof String ? "'" + value + "'" : value;
    }

    private static String statusLowerCase(Object status) {
        return status.toString().toLowerCase();
    }

    public static String plain(List<KeyDiff> formedList) {
        return formedList
                .stream()
                .filter(keyDiff -> !keyDiff.getStatus().equals(Status.UNCHANGED))
                .map(keyDiff -> {
                    Status status = keyDiff.getStatus();
                    Object valueFirst = complexToString(stringToDecor(keyDiff.getValueFirstMap()));
                    Object valueSecond = complexToString(stringToDecor(keyDiff.getValueSecondMap()));

                    return "Property '" + keyDiff.getName() + "' was " + statusLowerCase(status) + switch (status) {
                        case UPDATED -> ". From " + valueFirst + " to " + valueSecond;
                        case ADDED -> " with value: " + valueSecond;
                        default -> "";
                    };
                })
                .collect(Collectors.joining("\n"));
    }
}
