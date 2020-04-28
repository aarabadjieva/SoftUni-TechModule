import java.awt.*;
import java.util.*;
import java.util.List;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> typeAndName = new LinkedHashMap<>();
        Map<String, List<Integer>> nameAndStats = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            String typeName = input[0] + " " + input[1];
            int damage = 0;
            int health = 0;
            int armor = 0;
            if (input[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input[2]);
            }
            if (input[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input[3]);
            }
            if (input[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input[4]);
            }
            List<Integer> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);
            if (!typeAndName.containsKey(type)) {
                typeAndName.put(type, new ArrayList<>());
                typeAndName.get(type).add(name);
                nameAndStats.put(typeName, new ArrayList<>());
                nameAndStats.get(typeName).addAll(stats);
            } else {
                if (!typeAndName.get(type).contains(name)){
                    typeAndName.get(type).add(name);
                }
                if (!nameAndStats.containsKey(typeName)){
                    nameAndStats.put(typeName,stats);
                }else {
                    nameAndStats.replace(typeName, stats);
                }
            }
        }

        for (Map.Entry<String, List<String>> e1:typeAndName.entrySet()
             ) {
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (Map.Entry<String,List<Integer>> e2 : nameAndStats.entrySet()
                 ) {
                if (e1.getKey().equals(e2.getKey().split(" ")[0])){
                    averageDamage+=e2.getValue().get(0);
                    averageHealth+= e2.getValue().get(1);
                    averageArmor +=e2.getValue().get(2);
                }
            }
            averageDamage = (averageDamage*1.00)/e1.getValue().size();
            averageHealth = (averageHealth*1.00)/e1.getValue().size();
            averageArmor = (averageArmor*1.00)/e1.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",e1.getKey(),averageDamage,averageHealth,averageArmor);

            nameAndStats.entrySet().stream().sorted((a1,a2)->{
                String name1 = a1.getKey().split(" ")[1];
                String name2 = a2.getKey().split(" ")[1];

                return name1.compareToIgnoreCase(name2);
            }).forEach(a->{if (e1.getKey().equals(a.getKey().split(" ")[0])){
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",a.getKey().split(" ")[1],a.getValue().get(0),
                        a.getValue().get(1),a.getValue().get(2));
            }});

        }
    }
}
