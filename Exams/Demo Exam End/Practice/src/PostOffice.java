import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        List<Character> letters = new ArrayList<>();
        Map<Character, Integer> firstAndLenght = new LinkedHashMap<>();
        Pattern first = Pattern.compile("(?<=(?<symbol>[\\$#%&\\*|]))[A-Z]+(?=\\k<symbol>)");
        Matcher firstMatcher = first.matcher(input[0]);
        Pattern numbers = Pattern.compile("\\d+:\\d{2}");
        Matcher numberMatcher = numbers.matcher(input[1]);

        if (firstMatcher.find()){
            for (int i = 0; i < firstMatcher.group().length(); i++) {
                letters.add(firstMatcher.group().charAt(i));
            }
        }
        int size= letters.size();
        while (size>0){
            if (numberMatcher.find()) {
                int endIndex = numberMatcher.group().indexOf(":");
                String firstLetter = numberMatcher.group().substring(0, endIndex);
                String lenghtNumbers = numberMatcher.group().substring(endIndex + 1);
                char startingLetter = (char) Integer.parseInt(firstLetter);
                int lenght=0;
                if (lenghtNumbers.length()>0&&lenghtNumbers.length()<20) {
                    lenght = Integer.parseInt(lenghtNumbers);
                }
                if (letters.contains(startingLetter)) {
                    if (!firstAndLenght.containsKey(startingLetter)) {
                        firstAndLenght.put(startingLetter, lenght);
                        size--;
                    }
                }
            }
        }
        String[] words = input[2].split("\\s+");
            for (int i = 0; i < letters.size(); i++) {
                for (int j = 0; j <words.length ; j++) {
                    if (words[j].charAt(0)==letters.get(i)){
                        if (words[j].length()==firstAndLenght.get(letters.get(i))+1){
                            System.out.println(words[j]);
                        }
                    }
                }
            }



    }
}
