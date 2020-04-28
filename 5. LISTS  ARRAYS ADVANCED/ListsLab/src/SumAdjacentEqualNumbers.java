import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        int size = numbers.size();

        for (int i = 0; i < size-1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                size--;
                i = -1;
            }
        }
        String output = joinElementsByDelimeter(numbers, " ");
        System.out.println(output);
    }

    private static String joinElementsByDelimeter(List<Double> numbers, String s) {
        String output = "";
        for (double num : numbers
        ) {
            output += (new DecimalFormat("#.##").format(num) + s);
        }
        return output;
    }
}
