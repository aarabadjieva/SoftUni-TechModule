import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> productPrices = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("buy")){
            String[] item = line.split("\\s");
            String product = item[0];
            double price = Double.parseDouble(item[1]);
            int quantity = Integer.parseInt(item[2]);
            productPrices.putIfAbsent(product,price);
            productPrices.put(product,price);
            productQuantity.putIfAbsent(product,0);
            productQuantity.put(product,productQuantity.get(product)+quantity);
            line = scanner.nextLine();
        }
        for (Map.Entry<String,Double> entry:productPrices.entrySet()
             ) {
            String product = entry.getKey();

            System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()*productQuantity.get(product));
        }
    }
}
