import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MatchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(^|(?<=\\s))(-?\\d+\\.?\\d*)($|(?=\\s))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> digits = new ArrayList<>();
        while (matcher.find()){
            digits.add(matcher.group());
        }
        System.out.println(String.join(" ",digits));
    }
}
