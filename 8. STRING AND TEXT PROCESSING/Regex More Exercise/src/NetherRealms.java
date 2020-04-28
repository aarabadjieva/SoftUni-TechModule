import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s*");
        List<Demon> demons = new ArrayList<>();
        String letterRegex = "[^\\d+\\-*/.]";
        String numRegex = "[-|+]*[0.0-9]+";
        String actionRegex = "[*/]";
        Pattern letter = Pattern.compile(letterRegex);
        Pattern num = Pattern.compile(numRegex);
        Pattern action = Pattern.compile(actionRegex);
        for (String demon:input
             ) {
            demon = demon.trim();
            char[]symbols = demon.toCharArray();
            int health = 0;
            List<String> actions = new ArrayList<>();
            for (int i = 0; i < symbols.length; i++) {
                String temp = String.valueOf(symbols[i]);
                Matcher letterMatch = letter.matcher(temp);
                Matcher actionmatch = action.matcher(temp);
                if (letterMatch.find()){
                    health+=symbols[i];
                }else if (actionmatch.find()){
                    actions.add(actionmatch.group());
                }
            }
            double damage = 0;
            Matcher numMatch = num.matcher(demon);
            while (numMatch.find()){
                double number = Double.parseDouble(numMatch.group());
                damage+=number;
            }
            for (int i = 0; i < actions.size(); i++) {
                String symbol = actions.get(i);
                if (symbol.equals("*")){
                    damage = damage*2;
                }else if (symbol.equals("/")){
                    damage = damage/2;
                }
            }
            Demon currentDemon = new Demon(demon,health,damage);
            demons.add(currentDemon);
        }
        demons.stream().sorted(Comparator.comparing(Demon::getName)).forEach(d-> System.out.printf("%s - %d health, %.2f damage%n",d.getName(),d.getHealth(),d.getDamage()));

    }
}
class Demon{
   private String name;
   private int health;
   private double damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Demon(String name, int health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
}
