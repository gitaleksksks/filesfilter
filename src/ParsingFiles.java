import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ParsingFiles {

    public static void dataType(String line, List<Long> integers, List<Double> floats, List<String> strings) {
        try {
            integers.add(Long.parseLong(line));
        } catch (NumberFormatException e1) {
            try {
                floats.add(Double.parseDouble(line));
            } catch (NumberFormatException e2) {
                strings.add(line);
            }
        }
    }

    public static void writeToFile(List<?> list, String path, String fileName, boolean append) {
        if (list.isEmpty()) {
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + fileName, append))) {
            for (Object item : list) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + fileName + " - " + e.getMessage());
        }
    }
}
