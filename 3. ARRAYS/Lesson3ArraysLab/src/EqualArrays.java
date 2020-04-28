import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] one = scanner.nextLine().split(" ");
        int[] first = new int[one.length];
        for (int i = 0; i <one.length ; i++) {
            String number = one[i];
            first[i] = Integer.parseInt(number);
        }
        String[] two = scanner.nextLine().split(" ");
        int[] second = new int[two.length];
        for (int i = 0; i <two.length ; i++) {
            String number = two[i];
            second[i] = Integer.parseInt(number);
        }
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        for (int j = 0; j < Math.min(first.length,second.length); j++) {
            if (first[j]!=second[j]){
               diff = j;
                break;
            }else{
                sum +=first[j];
            }
        }
        if (diff!=Integer.MAX_VALUE){
            System.out.printf("Arrays are not identical. Found difference at %d index.",diff);
        }else{
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
