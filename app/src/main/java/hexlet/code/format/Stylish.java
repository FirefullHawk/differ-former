package hexlet.code.format;

import java.util.List;

import hexlet.code.Status;

public class Stylish {
    public static String stylish(List<Object> formedList) {
        final String[] result = {"{\n"};

        formedList
                .forEach(x -> {
                    String[] arr = x.toString().split("%");
                    String newLine = "";

                    if (arr[0].equals("updated")) {
                        arr[0] = "removed";
                        newLine = Status.added.getSigh() + arr[1] + ": " + arr[3] + "\n";
                    }

                    arr[0] = Status.updated.returnSigh(arr[0]);

                    result[0] += arr[0] + arr[1] + ": " + arr[2] + "\n" + newLine;
                });
        return result[0] + "}";
    }
}
