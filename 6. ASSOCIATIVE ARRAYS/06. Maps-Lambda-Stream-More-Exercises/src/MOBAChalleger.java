import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChalleger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> playerPool = new LinkedHashMap<>();
        Map<String, Integer> totalSkill = new LinkedHashMap<>();
        while (!line.equals("Season end")) {
            if (line.contains(" -> ")) {
                String[] input = line.split(" -> ");
                String name = input[0];
                String position = input[1];
                int skill = Integer.parseInt(input[2]);
                if (!playerPool.containsKey(name)) {
                    playerPool.put(name, new LinkedHashMap<>());
                    totalSkill.put(name,0);
                }
                if (!playerPool.get(name).containsKey(position)) {
                    playerPool.get(name).put(position, skill);
                    totalSkill.put(name,totalSkill.get(name)+skill);
                } else {
                    if (playerPool.get(name).get(position) < skill) {
                        int current = playerPool.get(name).get(position);
                        playerPool.get(name).replace(position, skill);
                        totalSkill.put(name,totalSkill.get(name)-current+skill);
                    }
                }
            } else if (line.contains(" vs ")){
                String[] input = line.split(" vs ");
                String player1 = input[0];
                String player2 = input[1];
                if (playerPool.containsKey(player1) && playerPool.containsKey(player2)) {
                    String playerToRemove = "";
                    for (Map.Entry<String, Integer> e1 : playerPool.get(player1).entrySet()
                    ) {
                        for (Map.Entry<String, Integer> e2 : playerPool.get(player2).entrySet()
                        ) {
                            if (e1.getKey().equals(e2.getKey())) {
                                if (e1.getValue() > e2.getValue()) {
                                    playerToRemove = player2;
                                    totalSkill.remove(player2);
                                    break;
                                } else if (e2.getValue() > e1.getValue()) {
                                    playerToRemove = player1;
                                    totalSkill.remove(player1);
                                    break;
                                }
                            }
                        }
                    }
                    playerPool.remove(playerToRemove);
                }
            }
            line = scanner.nextLine();
        }
        totalSkill.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
        .thenComparing(Map.Entry.comparingByKey())).forEach(e->{
            System.out.printf("%s: %d skill%n",e.getKey(),e.getValue());
            playerPool.get(e.getKey()).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey())).forEach(pl->
                    System.out.printf("- %s <::> %d%n",pl.getKey(),pl.getValue()));
        });
    }
}
