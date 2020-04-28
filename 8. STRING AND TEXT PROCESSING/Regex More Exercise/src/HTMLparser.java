import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HTMLparser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "(?<=>)([^<>\\\\\\d]+)|(?<=\\\\n)([^<>\\\\]+)";
        List<String> content = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            content.add(matcher.group());
        }
        System.out.println("Title: " + content.get(0).trim());
        System.out.print("Content: ");
        content.removeAll(Collections.singletonList("\\s+"));
        for (int i = 1; i <content.size() ; i++) {
            System.out.print(content.get(i).trim()+" ");
        }
    }
}
