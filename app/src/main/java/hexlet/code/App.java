package hexlet.code;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "find_diff", mixinStandardHelpOptions = true, version = "find_diff 0.1-a",
        description = "Compares two configuration files and shows a difference.")

public final class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Parameters(paramLabel = "filepath1", index = "0", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filepath2", index = "1", description = "path to second file")
    private String filePath2;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filePath1, filePath2, format));
        return 0;
    }
}
