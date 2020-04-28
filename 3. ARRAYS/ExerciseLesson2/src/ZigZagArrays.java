import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] first = new int[n];
        int[] second = new int[n];
        for (int i = 1; i <= n; i++) {
            String[] together = scanner.nextLine().split(" ");
            if (i%2!=0) {
                first[i-1] = Integer.parseInt(together[0]);
                second[i-1] = Integer.parseInt(together[1]);
            }else{
                first[i-1] = Integer.parseInt(together[1]);
                second[i-1] = Integer.parseInt(together[0]);
            }
        }
        for (int one : first
        ) {
            System.out.print(one + " ");
        }
        System.out.println();
        for (int two : second
        ) {
            System.out.print(two + " ");
        }
    }
}
