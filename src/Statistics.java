import java.util.Collections;
import java.util.List;

public class Statistics {

    public static void showStatistics(List<Long> integers, List<Double> floats, List<String> strings,
                                      boolean fullStatistics, boolean shortStatistics) {
        if (shortStatistics) {
            System.out.println("Статистика (короткая):");
            System.out.println("Целые числа: " + integers.size());
            System.out.println("Вещественные числа: " + floats.size());
            System.out.println("Строки: " + strings.size());
        }

        if (fullStatistics) {
            System.out.println("Статистика (полная):");
            showIntegerStatistics(integers);
            showFloatStatistics(floats);
            showStringStatistics(strings);
        }
    }

    public static void showIntegerStatistics(List<Long> integers) {
        if (integers.isEmpty()) return;
        long maxValue = Collections.max(integers);
        long minValue = Collections.min(integers);
        double average = integers.stream().mapToInt(i -> Math.toIntExact(i)).average().orElse(0);
        int sum = integers.stream().mapToInt(i -> Math.toIntExact(i)).sum();
        System.out.println("Количество целых чисел: " + integers.size());
        System.out.println("\nМинмальное значение: " + minValue + "\nМаксимальное значение: " + maxValue + "\nСумма: "
                + sum + "\nСреднее: " + average);
    }

    public static void showFloatStatistics(List<Double> floats) {
        if (floats.isEmpty()) return;
        double maxValue = Collections.max(floats);
        double minValue = Collections.min(floats);
        double average = floats.stream().mapToDouble(d -> d).average().orElse(0);
        double sum = floats.stream().mapToDouble(d -> d).sum();
        System.out.println("Количество вещественных чисел: " + floats.size());
        System.out.println("\nМинмальное значение: " + minValue + "\nМаксимальное значение: " + maxValue + "\nСумма: "
                + sum + "\nСреднее: " + average);
    }

    public static void showStringStatistics(List<String> strings) {
        if (strings.isEmpty()) return;
        int minLength = strings.stream().mapToInt(String::length).min().orElse(0);
        int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);
        System.out.println("Количество строк: " + strings.size());
        System.out.println("\nМинимальная длина: " + minLength + "\nМаксимальна длина: " + maxLength);
    }

}
