import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String regexValid = ">{2}([a-zA-Z]+)<{2}(\\d+[.]?\\d*)!(\\d+)";
        Pattern patternValid = Pattern.compile(regexValid);
        double sum = 0;
        System.out.println("Bought furniture:");
        while (!line.equals("Purchase")){
            Matcher matcherValid = patternValid.matcher(line);
            if (matcherValid.find()){
                System.out.println(matcherValid.group(1));
                double price = Double.parseDouble(matcherValid.group(2));
                int quantity = Integer.parseInt(matcherValid.group(3));
                sum+=price*quantity;
            }
            line = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
