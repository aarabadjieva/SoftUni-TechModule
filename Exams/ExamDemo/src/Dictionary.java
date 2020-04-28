import java.util.*;

public class Dictionary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] wordsAndDeffinitions = scanner.nextLine().split("\\|");
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < wordsAndDeffinitions.length; i++) {
            String[] word = wordsAndDeffinitions[i].split(":");
            String name = word[0].trim();
            String deffinition = word[1].trim();
            if (!dictionary.containsKey(name)) {
                dictionary.put(name, new ArrayList<>());
            }
            dictionary.get(name).add(deffinition);
        }
        String[] words = scanner.nextLine().split("\\|");
        for (String word:words
             ) {
            word = word.trim();
            if (dictionary.containsKey(word)){
                System.out.println(word);
                dictionary.get(word).stream().sorted(Comparator.comparingInt(String::length).reversed())
                        .forEach(e-> System.out.println("-"+e));
            }
        }
        String command = scanner.nextLine();
        if (command.equals("List")){
            List<String> allWords = new ArrayList<>();
            for (Map.Entry<String, List<String>> word:dictionary.entrySet()
                 ) {
                allWords.add(word.getKey());
            }
            allWords.stream().sorted().forEach(e-> System.out.print(e+" "));
        }
    }
}

