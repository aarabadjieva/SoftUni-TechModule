import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < numbers.length; i++) {
            int top = 0;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    top = 1;
                }
            }
            if (top==0){
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
