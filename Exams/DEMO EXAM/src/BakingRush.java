import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BakingRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = 100;
        int coins = 100;
        String[] events = scanner.nextLine().split("\\|");
        boolean isClosed = false;
        for (int i = 0; i < events.length; i++) {
            List<String> currentEvent = new ArrayList<String>(Arrays.asList(events[i].split("-")));
            if (currentEvent.get(0).equals("rest")) {
                int bonus = Integer.valueOf(currentEvent.get(1));
              if (energy<100){
                  int needed = 100-energy;
                  if (bonus<=needed){
                      energy+=bonus;
                  }else{
                      bonus=needed;
                      energy=100;
                  }
              }else{
                  bonus=0;
              }
                System.out.printf("You gained %d energy.",bonus);
                System.out.println();
                System.out.printf("Current energy: %d.",energy);
                System.out.println();
            } else if (currentEvent.get(0).equals("order")) {
               energy-=30;
               int earned = Integer.valueOf(currentEvent.get(1));
               if (energy>=0){
                   coins+=earned;
                   System.out.printf("You earned %d coins.",earned);
                   System.out.println();
               }else{
                   energy+=30;
                   energy+=50;
                   System.out.println("You had to rest!");
               }
            }else {
                int spend = Integer.parseInt(currentEvent.get(1));
                coins-=spend;
                String product = currentEvent.get(0);
                if (coins>0){
                    System.out.println("You bought "+product+".");
                }else{
                    System.out.println("Closed! Cannot afford "+product+".");
                    isClosed = true;
                    break;
                }
            }
        }
        if (!isClosed){
            System.out.println("Day completed!");
            System.out.println("Coins: "+coins);
            System.out.println("Energy: "+energy);
        }
    }
}
