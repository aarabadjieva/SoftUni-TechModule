import java.util.Scanner;

public class RefractorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int currNum = 0;
        boolean special = false;
        for (int number = 1; number <= range; number++) {
            currNum = number;
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            special = (sum == 5) || (sum == 7) || (sum == 11);
            String isSpecial = special+"";
            isSpecial = (isSpecial.charAt(0)+"").toUpperCase()+(isSpecial.substring(1));
            System.out.printf("%d -> %s%n", currNum, isSpecial);
            sum = 0;
            number = currNum;
        }

    }
}
