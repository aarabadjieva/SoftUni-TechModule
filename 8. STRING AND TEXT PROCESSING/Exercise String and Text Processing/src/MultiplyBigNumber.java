import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNumber = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int reminder = 0;
        if (bigNumber.equals("0")||multiplier==0){
            System.out.println("0");
        }else {
            for (int i = bigNumber.length() - 1; i >= 0; i--) {
                int num = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
                int sum = num * multiplier;
                if (reminder != 0) {
                    sum += reminder;
                    reminder = 0;
                }
                String toAppend = "";
                if (sum < 10) {
                    toAppend = String.valueOf(sum);
                } else {
                    toAppend = String.valueOf(sum % 10);
                    reminder = sum / 10;
                }
                result.append(toAppend);
            }
            if (reminder != 0) {
                String toAppend = String.valueOf(reminder);
                result.append(toAppend);
            }
            StringBuilder reversed = new StringBuilder();
            for (int i = result.length() - 1; i >= 0; i--) {
                reversed.append(result.charAt(i));
            }
            System.out.println(reversed);
        }
    }
}
