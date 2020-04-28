import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String countRegex = "[sStTaArR]";
        Pattern counter = Pattern.compile(countRegex);
        List<String> messages = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String crypted = scanner.nextLine();
            char[] symbols = crypted.toCharArray();
            int count = 0;
            for (int j = 0; j < symbols.length; j++) {
                String temp = String.valueOf(symbols[j]);
                Matcher countMatch = counter.matcher(temp);
                if (countMatch.find()){
                    count++;
                }
            }
            StringBuilder decrypted = new StringBuilder();
            for (int j = 0; j < symbols.length; j++) {
                char temp = (char) (symbols[j] - count);
                decrypted.append(temp);
            }
            String message = decrypted.toString();
            messages.add(message);
        }
        String regex = "@(?<planetname>[a-zA-Z]+)[^@\\-!:>.]*:(?<population>\\d+)[^@\\-!:>.]*!(?<type>[AD])![^@\\-!:>.]*\\->(?<soldiers>\\d+)[^@\\-!:>.]*";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (String message:messages
             ) {
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                String name = matcher.group("planetname");
                String type = matcher.group("type");
                if (type.equals("A")){
                    attackedPlanets.add(name);
                }else{
                    destroyedPlanets.add(name);
                }
            }
        }
        System.out.printf("Attacked planets: %d%n",attackedPlanets.size());
        attackedPlanets.stream().sorted().forEach(e-> System.out.printf("-> %s%n",e));
        System.out.printf("Destroyed planets: %d%n",destroyedPlanets.size());
        destroyedPlanets.stream().sorted().forEach(e-> System.out.printf("-> %s%n",e));
    }
}
