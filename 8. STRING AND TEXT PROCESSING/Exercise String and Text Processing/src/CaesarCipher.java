import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int current = input.charAt(i)+3;
            char toAppend = (char) current;
            cipher.append(toAppend);
        }
        System.out.println(cipher);
    }
}
