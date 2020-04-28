import java.util.Scanner;

public class RefractoringPrimeCheker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = Integer.parseInt(scanner.nextLine());
        for (int currNum = 2; currNum <= range; currNum++) {
            boolean isPrime = true;
            for (int delitel = 2; delitel < currNum; delitel++) {
                if (currNum % delitel == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", currNum, isPrime);
        }

    }
}
