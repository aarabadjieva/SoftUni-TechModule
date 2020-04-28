import java.util.Scanner;
public class RecursiveFibbonaci {
    private static long[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memo = new long [n+1];
        System.out.println(recursiveFibonacci(n));
    }

    private static long recursiveFibonacci(int n) {
        if (n<0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (memo[n]>0){
            return memo[n];
        }
        memo[n] = recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
        return memo[n];
    }
}
