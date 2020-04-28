import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] cmd = scanner.nextLine().split("\\s+");
        while (!cmd[0].equals("end")){
            if (cmd[0].equals("Delete")){
                int toDelete = Integer.valueOf(cmd[1]);
                numbers.removeIf(integer -> integer==toDelete);
            }else if (cmd[0].equals("Insert")){
                int number = Integer.valueOf(cmd[1]);
                int index = Integer.valueOf(cmd[2]);
                if (index<numbers.size()&&index>=0) {
                    numbers.add(index, number);
                }
            }
            cmd = scanner.nextLine().split("\\s+");
        }
        numbers.forEach(integer -> System.out.print(integer+" "));
    }
}
