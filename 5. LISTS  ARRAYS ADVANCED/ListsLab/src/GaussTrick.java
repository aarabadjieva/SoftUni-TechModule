import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        numbers = summedList(numbers);
        String output = joinElementsBySpace(numbers, " ");
        System.out.println(output);
    }

    private static List<Double> summedList(List<Double> numbers) {
        for (int i = 0; i <numbers.size()-1 ; i++) {
            if (numbers.size()==1){
                numbers.set(0,numbers.get(0));
            }else {
                numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
                numbers.remove(numbers.size() - 1);
            }
        }
        return numbers;
    }

    private static String joinElementsBySpace(List<Double> numbers, String s) {
        String output = "";
        for (double num:numbers
             ) {
          output+=new DecimalFormat("#.##").format(num)+s;
        }
        return output;
    }

}
