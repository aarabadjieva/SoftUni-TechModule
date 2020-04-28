import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int original = number;
        int sum = 0;

        while(number>0){
            int x=number%10;
            int fact = 1;
            for (int i = x; i >0 ; i--) {
                fact = fact*i;
            }
            sum+=fact;
            number=number/10;
        }
        if (sum==original){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
