import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.err.println("Нет входных файлов или названия файлов неправильно указаны");
            return;
        }

        String outputPath = "./";
        String prefix = "";
        boolean append = false;
        boolean fullStatistics = false;
        boolean shortStatistics = false;
        List<String> inputFiles = new ArrayList<>();

        for (String arg : args) {
            if (arg.equals("-o")) {
                outputPath = ParsingCommandLine.getNextArgument(args, arg);
            } else if (arg.equals("-p")) {
                prefix = ParsingCommandLine.getNextArgument(args, arg);
            } else if (arg.equals("-a")) {
                append = true;
            } else if (arg.equals("-s")) {
                shortStatistics = true;
            } else if (arg.equals("-f")) {
                fullStatistics = true;
            } else {
                inputFiles.add(arg);
            }
        }

        List<Long> integers = new ArrayList<>();
        List<Double> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (String inputFile : inputFiles) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    ParsingFiles.dataType(line, integers, floats, strings);
                }
            } catch (IOException e) {
                if (prefix != inputFile)
                System.err.println("Ошибка чтения файла: " + inputFile + " - " + e.getMessage());
            }
        }

        ParsingFiles.writeToFile(integers, outputPath, prefix + "integers.txt", append);
        ParsingFiles.writeToFile(floats, outputPath, prefix + "floats.txt", append);
        ParsingFiles.writeToFile(strings, outputPath, prefix + "strings.txt", append);

        Statistics.showStatistics(integers, floats, strings, fullStatistics, shortStatistics);
    }

}
