import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encriptedMessage = scanner.nextLine();
        String[] substrings = scanner.nextLine().split("\\s");
        String regex = "[^d-z#{}\\|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(encriptedMessage);
        if (matcher.find()){
            System.out.println("This is not the book you are looking for.");
        }else{
            StringBuilder message = new StringBuilder();
            char[] symbols = encriptedMessage.toCharArray();
            for (char symbol:symbols
                 ) {
                symbol = (char) (symbol-3);
                message.append(symbol);
            }
            String deciphredMessage = message.toString();
            String regexSubstring = substrings[0];
            String replacement = substrings[1];
            deciphredMessage = deciphredMessage.replaceAll(regexSubstring, replacement);
            System.out.println(deciphredMessage);
        }
    }
}
