import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonyms = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            synonyms.putIfAbsent(word, new ArrayList<>());
            List<String> synonymsByWord = synonyms.get(word);
            synonymsByWord.add(synonym);
        }
        synonyms.forEach((word, synonymsByword)->{
            System.out.print(word+" - ");
            System.out.println(String.join(", ",synonymsByword));
        });
    }
}
