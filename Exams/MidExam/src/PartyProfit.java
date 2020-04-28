import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int coins = 0;
        List<Integer> coinsPerDay = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            coins+=50;
            if (i%10==0){
                partySize-=2;
            }
            if (i%15==0){
                partySize+=5;
            }
            coins-=partySize*2;
            if (i%3==0){
                coins-=partySize*3;
            }
            if (i%5==0){
                coins+=partySize*20;
                if (i%3==0){
                    coins-=partySize*2;
                }
            }
        }int averageCoins = (int) Math.floor(coins/partySize);
        System.out.println(partySize+" companions received "+averageCoins+" coins each.");
    }
}
