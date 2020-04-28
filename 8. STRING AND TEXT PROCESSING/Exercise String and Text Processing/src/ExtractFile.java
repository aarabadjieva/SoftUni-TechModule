import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        String fileInfo = file.substring(file.lastIndexOf("\\")+1);
        Pattern pattern = Pattern.compile("(.*)\\.(.*)");
        Matcher matcher = pattern.matcher(fileInfo);
        matcher.find();
        System.out.println("File name: "+matcher.group(1));
        System.out.println("File extension: "+matcher.group(2));

    }
}
