import java.util.Scanner;

public class ExchangeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a  = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        System.out.printf("Before:\n" +
                "a = %d\nb = %d\nAfter:\na = %d\nb = %d",a,b,b,a);
    }
}
