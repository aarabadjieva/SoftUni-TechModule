import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int coins = 0;
        String[] rooms = scanner.nextLine().split("\\|");
        boolean end = false;
        for (int i = 0; i < rooms.length; i++) {
            List<String> currentRoom = Arrays.stream(rooms[i].split("\\s+")).collect(Collectors.toList());
            switch (currentRoom.get(0)){
                case "potion":
                    int health = Integer.parseInt(currentRoom.get(1));
                    int neededHealth = 100-initialHealth;
                    if (health>neededHealth){
                       health = neededHealth;
                    }
                    initialHealth+=health;
                    System.out.println("You healed for "+health+" hp.");
                    System.out.println("Current health: "+initialHealth+" hp.");
                    break;
                case "chest":
                    int foundCoins = Integer.parseInt(currentRoom.get(1));
                    coins+=foundCoins;
                    System.out.println("You found "+foundCoins+" coins.");
                    break;
                    default:
                        int monsterPower = Integer.parseInt(currentRoom.get(1));
                        initialHealth -= monsterPower;
                        if (initialHealth>0){
                            System.out.println("You slayed "+currentRoom.get(0)+".");
                        }else {
                            System.out.println("You died! Killed by "+currentRoom.get(0)+".");
                            end = true;
                            int bestRoom = i+1;
                            System.out.println("Best room: "+bestRoom);
                            break;
                        }
                       break;
            }
            if (end){
                break;
            }
        }
        if (!end){
            System.out.println("You've made it!");
            System.out.println("Coins: "+coins);
            System.out.println("Health: "+initialHealth);
        }
    }
}
