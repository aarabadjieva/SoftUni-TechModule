import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int multi = Integer.parseInt(scanner.nextLine());
        int sum = n*multi;
        do {
            System.out.println(n+" X "+multi+" = "+sum);
            multi++;
            sum = n*multi;
        }while (multi<=10);
    }
}
