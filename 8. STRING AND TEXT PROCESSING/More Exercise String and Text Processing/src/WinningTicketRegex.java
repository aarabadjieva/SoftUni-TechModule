import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicketRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        for (String ticket:tickets
             ) {
            ticket = ticket.trim();
            if (ticket.length()!=20){
                System.out.println("invalid ticket");
            }else{
                Pattern pattern = Pattern.compile("[@#$^]+");
                String leftHalf = ticket.substring(0,10);
                String rightHalf = ticket.substring(10,20);

                Matcher leftMatch = pattern.matcher(leftHalf);
                Matcher rightMatch = pattern.matcher(rightHalf);
                String left = "1";
                String right = "2";
                if (leftMatch.find()){
                    left = leftMatch.group();
                }
                if (rightMatch.find()){
                    right = rightMatch.group();
                }
                int min = Math.min(left.length(),right.length());
                if (left.charAt(0)==right.charAt(0)){
                    if (min==10){
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",ticket,min,left.charAt(0));
                    }else if (min>=6){
                        System.out.printf("ticket \"%s\" - %d%s%n",ticket,min,left.charAt(0));
                    }else{
                        System.out.printf("ticket \"%s\" - no match%n",ticket);
                    }
                }else {
                    System.out.printf("ticket \"%s\" - no match%n",ticket);
                }
            }
        }
    }
}
