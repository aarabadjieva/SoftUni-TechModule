import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int digits;
        int main = 0;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n / 1000 > 1) {
                digits = 4;
            } else if (n / 100 > 1) {
                digits = 3;
            } else if (n / 10 > 1) {
                digits = 2;
            } else {
                digits = 1;
            }
            int index;
            char letter = 97;
            if (n == 0) {
                letter = (char) (32);
            } else {
                while (n > 0) {
                    main = n % 10;
                    n = n / 10;
                }
                int offset;
                if (main != 8 && main != 9) {
                    offset = (main - 2) * 3;
                } else {
                    offset = (main - 2) * 3 + 1;
                }
                index = offset + digits - 1;
                letter = (char) ((char) (index) + letter);
            }
            message.append(letter);
        }
        System.out.println(message.toString());
    }
}
