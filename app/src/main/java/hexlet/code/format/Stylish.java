package hexlet.code.format;

import java.util.List;
import java.util.stream.Collectors;

import hexlet.code.KeyDiff;
import hexlet.code.Status;

public class Stylish {
    private static String getSigh(Status status) {
        return switch (status) {
            case ADDED -> (" ".repeat(2) + "+ ");
            case UNCHANGED -> (" ".repeat(2) + "  ");
            case REMOVED -> (" ".repeat(2) + "- ");
            default -> (" ".repeat(2) + "+-");
        };
    }
    public static String stylish(List<KeyDiff> formedList) {
        String result = "{\n";

        result += formedList
                .stream()
                .map(keyDiff -> {
                    String sigh = getSigh(keyDiff.getStatus());
                    String name = keyDiff.getName();
                    Status status = keyDiff.getStatus();

                    return switch (status) {
                        case ADDED -> sigh + name + ": " + keyDiff.getValueSecondMap();
                        case UPDATED -> getSigh(Status.REMOVED) + name + ": " + keyDiff.getValueFirstMap() + "\n"
                                + getSigh(Status.ADDED) + name + ": " + keyDiff.getValueSecondMap();
                        default -> sigh + name + ": " + keyDiff.getValueFirstMap();
                    };
                })
                .collect(Collectors.joining("\n"));
        return result + "\n}";
    }
}
