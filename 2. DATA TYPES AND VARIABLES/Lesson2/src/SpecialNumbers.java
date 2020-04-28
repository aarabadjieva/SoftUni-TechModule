import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n ; i++) {
            int sum = 0;
            int number = i;
            while (number>0){
                int digit = number%10;
                number=number/10;
                sum+=digit;
            }
            boolean special = (sum==5)||(sum==7)||(sum==11);
            String answer = special+"";
            answer = (answer.charAt(0)+"").toUpperCase()+(answer.substring(1));
            System.out.printf("%d -> %s%n", i,answer );
        }
    }
}

