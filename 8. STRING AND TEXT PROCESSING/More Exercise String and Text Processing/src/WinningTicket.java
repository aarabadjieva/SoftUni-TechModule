import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        List<Character> winningSymbols = Arrays.asList('@', '#', '$', '^');
        for (String ticket : tickets
        ) {
            ticket = ticket.trim();
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                for (int i = 0; i < winningSymbols.size(); i++) {
                    char winningSymbol = winningSymbols.get(i);
                   if (!winningTicket(ticket,winningSymbol)){
                       if (i<winningSymbols.size()-1){
                           continue;
                       }else{
                           System.out.printf("ticket \"%s\" - no match%n",ticket);
                       }
                   }else{
                       break;
                   }
                }
            }
        }
    }
    public static boolean winningTicket(String ticket, char winningSymbol){
        String leftHalf = ticket.substring(0, 10);
        String rightHalf = ticket.substring(10, 20);
        StringBuilder winningCombination = new StringBuilder();
        for (int i = 0; i <leftHalf.length() ; i++) {
            char temp = leftHalf.charAt(i);
            if (temp==winningSymbol){
                winningCombination.append(temp);
            }else{
                i++;
            }
            }
        if (winningCombination.length()<6){
            return false;
        }else if (winningCombination.length()<10){
            if (rightHalf.contains(winningCombination)){
                System.out.printf("ticket \"%s\" - %d%s%n",ticket,winningCombination.length(),winningCombination.charAt(0));
                return true;
            }else{
                while (winningCombination.length()>6){
                    winningCombination.deleteCharAt(0);
                    if (rightHalf.contains(winningCombination)){
                        System.out.printf("ticket \"%s\" - %d%s%n",ticket,winningCombination.length(),winningCombination.charAt(0));
                        return true;
                    }
                }
            }
        }else{
            if (rightHalf.contains(winningCombination)){
                System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",ticket,winningCombination.length(),winningCombination.charAt(0));
                return true;
            }else{
                while (winningCombination.length()>6){
                    winningCombination.deleteCharAt(0);
                    if (rightHalf.contains(winningCombination)){
                        System.out.printf("ticket \"%s\" - %d%s%n",ticket,winningCombination.length(),winningCombination.charAt(0));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
