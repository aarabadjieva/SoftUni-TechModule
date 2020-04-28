import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chars = scanner.nextLine().replace(" ","");
        Map<Character,Integer> counter = new LinkedHashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            counter.putIfAbsent(chars.charAt(i),0);
            counter.put(chars.charAt(i),counter.get(chars.charAt(i))+1);
        }
        for (Map.Entry<Character,Integer> entry:counter.entrySet()){
            System.out.print(entry.getKey()+" -> ");
            System.out.println(entry.getValue());
        }
    }
}
