import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int max;
        int med;
        int min;
        if (n1>n2&&n1>n3){
            max=n1;
            if (n2>n3){
                med=n2;
                min=n3;
            }else{
                med=n3;
                min=n2;
            }
        }else if (n2>n1&&n2>n3){
            max=n2;
            if (n1>n3){
                med=n1;
                min=n3;
            }else{
                med=n3;
                min=n1;
            }
        }else{
            max=n3;
            if (n1>n2){
                med=n1;
                min=n2;
            }else{
                med=n2;
                min=n1;
            }
        }
        System.out.println(max);
        System.out.println(med);
        System.out.println(min);
    }
}
