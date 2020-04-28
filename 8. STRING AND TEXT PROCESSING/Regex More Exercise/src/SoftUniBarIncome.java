import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>[\\w]+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.\\d]*(?<price>\\d+[.]?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);
        String line = scanner.nextLine();
        double totalSum = 0;
        while (!line.equals("end of shift")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalSpent = quantity*price;
                totalSum+=totalSpent;
                System.out.printf("%s: %s - %.2f%n",name,product,totalSpent);
            }
            line = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);
    }
}
