import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().toLowerCase().split("\\s")).collect(Collectors.toList());
        Map<String, Integer> oddCounter = new LinkedHashMap<>();
        for (String word:words
             ) {
            oddCounter.putIfAbsent(word,0);
            oddCounter.put(word,oddCounter.get(word)+1);
        }
        List<String> result = new ArrayList<>();
       for (Map.Entry<String, Integer> entry : oddCounter.entrySet()){
           if (entry.getValue()%2!=0){
              result.add(entry.getKey());
           }
       }
        System.out.println(String.join(", ",result));
    }
}
