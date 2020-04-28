import java.util.*;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> quality = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List <Integer> prices = quality.stream().map(e->e*3).collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(line);
            for (int i = 0; i < quality.size(); i++) {
                quality.set(i,quality.get(i)-hitPower);
                if (quality.get(i)<=0){
                    double price = 1.00*prices.get(i);
                    if (savings>=price){
                        savings-=price;
                        quality.set(i,prices.get(i)/3);
                    }else{
                       quality.remove(i);
                       prices.remove(i);
                       i--;
                    }
                }
            }
            line = scanner.nextLine();
        }

        quality.stream().forEach(e-> System.out.print(e+" "));
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",savings);
    }
}
