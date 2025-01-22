import java.util.Arrays;

public class ParsingCommandLine {

    public static String getNextArgument(String[] args, String currentArg) {
        int index = Arrays.asList(args).indexOf(currentArg);
        if (index + 1 < args.length) {
            return args[index + 1];
        }
        return null;
    }

}
