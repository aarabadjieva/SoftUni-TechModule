import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        List<String> text = new ArrayList<>((Arrays.asList(input.split(""))));
        int number = 0;
        int index = 0;
        String message ="";
        for (int i = 0; i < numbers.size(); i++) {
            number = numbers.get(i);
            while (number>0){
                index+=number%10;
                number = number/10;
            }
            if (index>=text.size()){
                index = index%text.size();
            }
            message+=text.get(index);
            text.remove(index);
            index = 0;
        }
        System.out.println(message);
    }
}
