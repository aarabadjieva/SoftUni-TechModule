import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("end")){
            if (input[0].equals("Add")){
                wagons.add(Integer.valueOf(input[1]));
            }else{
                int passengers = Integer.valueOf(input[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i)+passengers<=maxCapacity){
                        wagons.set(i,wagons.get(i)+passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
        wagons.forEach(e-> System.out.print(e+" "));
    }
}
