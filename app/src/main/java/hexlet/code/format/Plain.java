package hexlet.code.format;

import java.util.List;

public class Plain {
    public static String plain(List<Object> formedList) {
        final String[] result = {""};

        formedList
                .stream()
                .filter(x -> !x.toString().startsWith("unchanged"))
                .forEach(x -> {
                    String[] arr = x.toString().split("%");

                    if (arr[2].contains("[") || arr[2].contains("{")) {
                        arr[2] = "[complex value]";
                    }

                    if (arr[3].contains("[") || arr[3].contains("{")) {
                        arr[3] = "[complex value]";
                    }

                    String upgradedFromTo = "";

                    if (arr[0].equals("updated")) {
                        upgradedFromTo += " From " + arr[2] + " to " + arr[3];
                    }

                    result[0] += "\nProperty '" + arr[1] + "' was " + arr[0] + "." + upgradedFromTo;
                }
            );
        return result[0].trim();
    }
}
