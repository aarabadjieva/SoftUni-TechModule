import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double eps = 0.000001;
        double diff = Math.abs(num1-num2);
        boolean isTrue = diff<eps;
        boolean isFalse = diff>=eps;
        if (isTrue){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
