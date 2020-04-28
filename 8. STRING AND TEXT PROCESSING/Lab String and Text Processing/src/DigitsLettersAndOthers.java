import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String digits = input.replaceAll("\\D","");
        String letters = input.replaceAll("[^a-zA-Z]","");
        StringBuilder others = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char result = input.charAt(i);
            if (!Character.isDigit(result)&&!Character.isLetter(result)){
                others.append(result);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
