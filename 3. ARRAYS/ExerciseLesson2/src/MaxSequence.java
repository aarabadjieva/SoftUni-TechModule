import java.util.Arrays;
import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxCount =0;
        int num = 0;
        for (int i = 0; i <numbers.length ; i++) {
            int count=0;
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i]==numbers[j]){
                    count++;
                }else{
                    break;
                }
            }
            if (count>maxCount){
                maxCount=count;
                num=numbers[i];
            }
        }
        int[] maxSequence = new int[maxCount+1];
        for (int k = 0; k <=maxCount ; k++) {
            maxSequence[k]=num;
        }
        for (int number:maxSequence) {
            System.out.print(number+" ");

        }
    }
}
