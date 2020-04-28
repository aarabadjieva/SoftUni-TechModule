import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int input;
        if (n % 2 == 0) {
            System.out.println("The number is: " + Math.abs(n));
        } else {
            do {
                System.out.println("Please write an even number.");
                input = Integer.parseInt(scanner.nextLine());
            } while (input % 2 != 0); {
                System.out.println("The number is: " + Math.abs(input));
            }
        }
    }
}