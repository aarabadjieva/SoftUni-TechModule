import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String,Integer>> contests = new LinkedHashMap<>();
        Map<String,Integer> users = new LinkedHashMap<>();
        while (!line.equals("no more time")){
            String[] input = line.split(" -> ");
            String userName = input[0];
            String contest = input[1];
            int points = Integer.parseInt(input[2]);
            if (!contests.containsKey(contest)){
                contests.put(contest,new LinkedHashMap<>());
                contests.get(contest).put(userName,points);
                if (!users.containsKey(userName)){
                    users.put(userName,0);
                    int total = users.get(userName)+points;
                    users.replace(userName,total);
                }else{
                    users.replace(userName,users.get(userName)+points);
                }
            }else{
                if (!contests.get(contest).containsKey(userName)){
                    contests.get(contest).put(userName,points);
                    if (!users.containsKey(userName)){
                        users.put(userName,0);
                        int total = users.get(userName)+points;
                        users.replace(userName,total);
                    }else{
                        users.replace(userName,users.get(userName)+points);
                    }
                }else{
                    if (contests.get(contest).get(userName)<points){
                        int toRemove = contests.get(contest).get(userName);
                        users.replace(userName,users.get(userName)+points-toRemove);
                        contests.get(contest).replace(userName,points);
                    }
                }
            }
            line = scanner.nextLine();
        }

        contests.entrySet().stream().forEach(e->{
            final int[] num = {1};
            System.out.printf("%s: %d participants%n",e.getKey(),e.getValue().size());
            e.getValue().entrySet().stream().sorted((e1, e2) -> {

                        int result = Integer.compare(e2.getValue(), e1.getValue());

                        if (result == 0) {

                            result = e1.getKey().compareTo(e2.getKey());
                        }

                        return result;

                    }
            ).forEach(cl-> {
                System.out.printf("%d. %s <::> %d%n", num[0],cl.getKey(),cl.getValue());
                num[0]++;
            });
        });
        final int[] position = {1};
        System.out.println("Individual standings:");
        users.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue(), e1.getValue());

            if (result == 0) {

                result = e1.getKey().compareTo(e2.getKey());
            }

            return  result;
        })
                .forEach(e-> {
                    System.out.printf("%d. %s -> %d%n", position[0],e.getKey(),e.getValue());
                    position[0]++;
                });
    }
}
