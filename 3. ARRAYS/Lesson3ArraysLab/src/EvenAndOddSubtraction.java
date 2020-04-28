import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int [] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            String num = input[i];
            numbers[i] = Integer.parseInt(num);
        }
        int sumEven = 0;
        int sumOdd = 0;
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j]%2==0){
                sumEven+=numbers[j];
            }else{
                sumOdd+=numbers[j];
            }
        }
        int diff=sumEven-sumOdd;
        System.out.println(diff);
    }
}
