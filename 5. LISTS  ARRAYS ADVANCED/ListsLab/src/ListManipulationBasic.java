import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            if (command[0].toLowerCase().equals("add")) {
                numbers = addNumberAtEnd(numbers, Integer.valueOf(command[1]));
            } else if (command[0].toLowerCase().equals("remove")) {
                numbers = removeNumber(numbers, Integer.valueOf(command[1]));
            } else if (command[0].toLowerCase().equals("removeat")) {
                numbers = removeNumberAtIndex(numbers, Integer.valueOf(command[1]));
            } else if (command[0].toLowerCase().equals("insert")) {
                numbers = insertNumberAtIndex(numbers, Integer.valueOf(command[1]), Integer.valueOf(command[2]));
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }

    private static List<Integer> insertNumberAtIndex(List<Integer> numbers, int digit, int index) {
        numbers.add(index, digit);
        return numbers;
    }

    private static List<Integer> removeNumberAtIndex(List<Integer> numbers, int index) {
        numbers.remove(index);
        return numbers;
    }

    private static List<Integer> removeNumber(List<Integer> numbers, int digit) {
        numbers.remove(Integer.valueOf(digit));
        return numbers;
    }

    private static List<Integer> addNumberAtEnd(List<Integer> numbers, int digit) {
        numbers.add(digit);
        return numbers;
    }
}
