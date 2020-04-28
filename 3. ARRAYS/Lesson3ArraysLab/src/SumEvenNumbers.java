import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numberString = scanner.nextLine().split(" ");
        int[] numbers = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++) {
            String numToBe = numberString[i];
            int number = Integer.parseInt(numToBe);
            numbers[i] = number;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==0){
                sum+=numbers[i];
            }
        }
        System.out.println(sum);
    }
}
