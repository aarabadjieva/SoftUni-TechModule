import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.asList(scanner.nextLine().split(", "));
        String line = scanner.nextLine();
        Map<String, Integer> runners = new LinkedHashMap<>();
        String regexLetters = "[a-zA-Z]";
        String regexNumbers = "[\\d]";
        Pattern letters = Pattern.compile(regexLetters);
        Pattern numbers = Pattern.compile(regexNumbers);

        while (!line.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            int distance = 0;
            char[] symbols = line.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                String temp = String.valueOf(symbols[i]);
                Matcher letterMatch = letters.matcher(temp);
                Matcher numberMatch = numbers.matcher(temp);
                if (letterMatch.find()) {
                    name.append(temp);
                } else if (numberMatch.find()) {
                    distance += Integer.parseInt(temp);
                }
            }
            String runner = name.toString();
            if (participants.contains(runner)) {
                if (!runners.containsKey(runner)) {
                    runners.put(runner, distance);
                } else {
                    int newDistance = runners.get(runner) + distance;
                    runners.put(runner, newDistance);
                }
            }
            line = scanner.nextLine();
        }
        for (int i = 0; i < 3; i++) {

        }
        List<String> first = new ArrayList<>();
        runners.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).forEach(e -> first.add(e.getKey()));
        System.out.printf("1st place: %s%n2nd place: %s%n3rd place: %s%n", first.get(0), first.get(1), first.get(2));
    }
}
