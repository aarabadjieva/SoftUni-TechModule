import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count=0;
        for (int i = 0; i <numbers.length ; i++) {
            int sumLeft =0;
            int sumRight=0;
            for (int j = 0; j <i ; j++) {
                sumLeft+=numbers[j];
            }
            for (int j = i+1; j <numbers.length ; j++) {
                sumRight+=numbers[j];
            }
            if (sumLeft==sumRight){
                count+=1;
                System.out.println(i);
            }
        }
        if (count==0){
            System.out.println("no");
        }
    }
}
