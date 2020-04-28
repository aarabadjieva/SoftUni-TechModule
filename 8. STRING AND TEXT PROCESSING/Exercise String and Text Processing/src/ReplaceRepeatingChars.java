import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder(input);
        List<Integer> toDelete = new ArrayList<>();
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i)==input.charAt(i+1)){
                toDelete.add(i+1);
            }
        }
        for (int i = toDelete.size()-1; i >=0 ; i--) {
            result.deleteCharAt(toDelete.get(i));
        }
        System.out.println(result);
    }
}
