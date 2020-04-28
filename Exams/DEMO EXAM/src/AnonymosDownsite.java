import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymosDownsite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sitesDown = Integer.parseInt(scanner.nextLine());
        int securityKey = Integer.parseInt(scanner.nextLine());
        double totalLoss =0;
        for (int i = 0; i <sitesDown ; i++) {
            List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            System.out.println(data.get(0));
            double siteLoss = Double.parseDouble(data.get(1))*Double.parseDouble(data.get(2));
            totalLoss+=siteLoss;
        }
        double securityToken = Math.pow(securityKey,sitesDown);
        System.out.printf("Total Loss: %.20f",totalLoss);
        System.out.println();
        System.out.printf("Security Token: %.0f",securityToken);
    }
}
