import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = firstNum; i <=lastNum ; i++) {
            sum+=i;
            System.out.printf("%d ",i);
        }
        System.out.printf("\nSum: %d",sum);
    }
}
