import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String numbers = scan.nextLine();
            int space = numbers.indexOf(" ");
            String num1 = numbers.substring(0,space);
            String num2 = numbers.substring(space+1);
           try {
               long n1 = Long.parseLong(num1);
               long n2 = Long.parseLong(num2);
               long sum = 0;
               if (n1>=n2){
                   while (Math.abs(n1)>0){
                       sum+=n1%10;
                       n1=n1/10;
                   }
               }else{
                   while (Math.abs(n2)>0){
                       sum+=n2%10;
                       n2=n2/10;
                   }
               }
               System.out.println(Math.abs(sum));
           }catch (NumberFormatException e){}

        }
    }
}
