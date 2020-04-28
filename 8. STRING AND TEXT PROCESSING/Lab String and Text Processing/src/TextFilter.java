import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String banned:bannedWords
             ) {
            while (text.contains(banned)){
                String replacement = banned.replaceAll(".","*");
                text = text.replace(banned,replacement);
            }
        }
        System.out.println(text);
    }
}
