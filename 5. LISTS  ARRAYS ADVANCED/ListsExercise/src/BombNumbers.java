import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] special = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bomb = special[0];
        int power = special[1];
        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
           int areaLeft = index-power;
           int areaRight = index+power;
           if (areaLeft<0){
               areaLeft=0;
           }
           if (areaRight>numbers.size()-1){
               areaRight=numbers.size()-1;
           }
            for (int i = areaLeft; i <=areaRight ; i++) {
                numbers.remove(areaLeft);
            }
        }
        int sum = 0;
        for (int i = 0; i <numbers.size() ; i++) {
            sum+=numbers.get(i);
        }
        System.out.println(sum);
    }
}
