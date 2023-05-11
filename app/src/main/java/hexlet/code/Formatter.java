package hexlet.code;

import hexlet.code.format.JSON;
import hexlet.code.format.Plain;
import hexlet.code.format.Stylish;

import java.io.IOException;
import java.util.List;

public class Formatter {
    public static String format(List<KeyDiff> formedList, String formatName) throws IOException {
        return switch (formatName) {
            case "json" -> JSON.json(formedList);
            case "plain" -> Plain.plain(formedList);
            case "stylish" -> Stylish.stylish(formedList);
            default -> throw new IOException("The '" + formatName + "' format does not exist.\n"
                    + "Check -h or --help key for available format.");
        };
    }
}
