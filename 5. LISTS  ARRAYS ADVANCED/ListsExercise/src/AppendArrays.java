import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(arrays);
        String result = arrays.toString().replaceAll("[\\]\\[,]", "").trim();
        result =result.replaceAll("\\s+"," ");
        System.out.println(result);


    }
}
