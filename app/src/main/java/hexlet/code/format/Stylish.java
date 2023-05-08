package hexlet.code.format;

import java.util.List;

import hexlet.code.Element;
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
    public static String stylish(List<Element> formedList) {
        final String[] result = {"{\n"};

        formedList
                .forEach(x -> {
                    String sigh = getSigh(x.getStatus());
                    String name = x.getName();
                    Object value = x.getValueFirstMap();
                    String newLine = "";

                    if (x.getStatus().equals(Status.UPDATED)) {
                        sigh = getSigh(Status.REMOVED);
                        newLine = getSigh(Status.ADDED) + name + ": " + x.getValueSecondMap() + "\n";
                    }

                    if (x.getStatus().equals(Status.ADDED)) {
                        value = x.getValueSecondMap();
                    }

                    String line = sigh + name + ": " + value + "\n";

                    result[0] += line + newLine;
                });
        return result[0] + "}";
    }
}
