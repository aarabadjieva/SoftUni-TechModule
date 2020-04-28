import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double,Integer> countNumbers = new TreeMap<>();
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for (double num:numbers){
            countNumbers.putIfAbsent(num,0);
            countNumbers.put(num,countNumbers.get(num)+1);
        }
        for (Map.Entry<Double,Integer> entry:countNumbers.entrySet()
             ) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n",df.format(entry.getKey()),entry.getValue());
        }
    }
}
