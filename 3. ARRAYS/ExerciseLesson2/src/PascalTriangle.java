import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int x =2;
        int[] begining = {1};
        System.out.println(begining[0]);
        for (int i = 1; i < n; i++) {
            int[] line = new int[x];
            for (int j = 0; j < line.length; j++) {
                if (j==0||j==line.length-1){
                    line[j]=1;
                }else{
                    line[j]=begining[j-1]+begining[j];
                }
            }
            for (int num:line
                 ) {
                System.out.print(num+" ");
            }
            System.out.println();
            x++;
            begining=line;
        }
    }
}
