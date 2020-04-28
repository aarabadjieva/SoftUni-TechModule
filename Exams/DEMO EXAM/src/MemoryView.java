import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> all = new ArrayList<>();
        while (!line.equals("Visual Studio crash")){
            List<String> current = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            all.addAll(current);
            line=scanner.nextLine();
        }
        all.removeIf(e->e.equals("0"));
        List<Character> words = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals("32656")&&all.get(i+1).equals("19759")&&all.get(i+2).equals("32763")){
                int startIndex = i+4;
                int endIndex = startIndex+Integer.parseInt(all.get(i+3));
                for (int j = startIndex; j <endIndex ; j++) {
                    words.add((char)(Integer.parseInt(all.get(j))));
                }
                words.forEach(e-> System.out.print(e));
                System.out.println();
                words.removeAll(words);
            }
        }

    }
}
