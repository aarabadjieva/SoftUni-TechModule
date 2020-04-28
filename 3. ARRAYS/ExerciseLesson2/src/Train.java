import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int wagon[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            wagon[i] = Integer.parseInt(scanner.nextLine());
            sum+=wagon[i];
        }
        for (int pp:wagon
             ) {
            System.out.print(pp+" ");
        }
        System.out.println("\n" + sum);
    }
}
