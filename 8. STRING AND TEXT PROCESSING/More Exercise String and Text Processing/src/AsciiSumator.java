import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char begining = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        if (begining>end){
            char temp = begining;
            begining = end;
            end = temp;
        }
        String line = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            char toAdd = line.charAt(i);
            if (toAdd>begining&&toAdd<end){
                sum+=toAdd;
            }
        }
        System.out.println(sum);
    }
}
