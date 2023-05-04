package hexlet.code.format;

import java.util.List;

import hexlet.code.Element;
import hexlet.code.Status;

public class Stylish {
    public static String stylish(List<Element> formedList) {
        final String[] result = {"{\n"};

        formedList
                .forEach(x -> {
                    String newLine = "";

                    if (x.getStatus().equals(Status.updated)) {
                        x.setStatus(Status.removed);
                        newLine = Status.added.getSigh() + x.getName() + ": " + x.getValueSecondMap() + "\n";
                    }

                    if (x.getStatus().equals(Status.added)) {
                        x.setValueFirstMap(x.getValueSecondMap());
                    }

                    result[0] += x.getStatus().getSigh() + x.getName() + ": " + x.getValueFirstMap() + "\n" + newLine;
                });
        return result[0] + "}";
    }
}
