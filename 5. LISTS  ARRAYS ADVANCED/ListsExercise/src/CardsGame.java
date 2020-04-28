import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> player1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> player2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (player1.size() > 0 && player2.size() > 0) {
            int player1card = player1.get(0);
            int player2card = player2.get(0);
            if (player1card > player2card) {
                player1.add(player1card);
                player1.add(player2card);
            } else if (player2card > player1card) {
                player2.add(player2card);
                player2.add(player1card);
            }
            player1.remove(0);
            player2.remove(0);
        }
        int sum = 0;
        if (player1.size() > player2.size()) {
            for (int element : player1
            ) {
                sum += element;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (int element : player2
            ) {
                sum += element;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
