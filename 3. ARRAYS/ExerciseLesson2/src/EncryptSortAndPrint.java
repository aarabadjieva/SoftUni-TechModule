import java.util.Scanner;

public class EncryptSortAndPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrays = Integer.parseInt(scanner.nextLine());
        int result[] = new int[arrays];
        for (int i = 0; i < arrays; i++) {
            String input = scanner.nextLine();
            char[] name = input.toCharArray();
            int sum = 0;
            for (int j = 0; j < name.length; j++) {
                int x=0;
                if (name[j]==65||name[j]==69||name[j]==73||name[j]==79||name[j]==85||
                name[j]==97||name[j]==101||name[j]==105||name[j]==111||name[j]==117){
                    x = name[j]*name.length;
                }else{
                    x = name[j]/name.length;
                }
                sum+=x;
            }
            result[i] = sum;
        }
        int max = 0;
        for (int i = 0; i <result.length ; i++) {
            for (int j = i+1; j <result.length ; j++) {
                if (result[i] > result[j]) {
                    max = result[i];
                    result[i] = result[j];
                    result[j] = max;
                }
            }
        }
        for (int line:result
             ) {
            System.out.println(line+"");

        }
    }
}
