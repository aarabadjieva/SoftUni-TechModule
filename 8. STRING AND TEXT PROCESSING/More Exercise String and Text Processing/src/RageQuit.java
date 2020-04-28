import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split("\\d+");
        int[] numbers = Arrays.stream(line.replaceAll("\\D", " ").trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        StringBuilder allSymbols = new StringBuilder();
        int grow = 0;
        for (String string : strings
        ) {
            for (int i = 0; i < numbers[grow]; i++) {
                allSymbols.append(string.toUpperCase());
            }
            grow++;
        }
        counter = uniqueSymbolsCounter(strings, numbers);
        System.out.println("Unique symbols used: " + counter);
        System.out.println(allSymbols.toString());
    }

    private static int uniqueSymbolsCounter(String[] strings, int[] numbers) {
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (numbers[i] == 0) {
                continue;
            } else {
                String string = strings[i].toUpperCase();
                for (int j = 0; j < string.length(); j++) {
                    char temp = string.charAt(j);
                    if (!unique.toString().contains(String.valueOf(temp))) {
                        unique.append(temp);
                    }
                }
            }
        }

        return unique.length();
    }
}
