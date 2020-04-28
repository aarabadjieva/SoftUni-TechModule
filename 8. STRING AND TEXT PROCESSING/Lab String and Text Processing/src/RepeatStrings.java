import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String string:strings
             ) {
            int count = string.length();
            for (int i = 0; i < count; i++) {
                result.append(string);
            }
        }
        System.out.println(result);
    }
}
