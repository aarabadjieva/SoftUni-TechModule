package TeamWorkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Team> teams = new TreeMap<>();
        List<String> allUsers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("-");
            String user = input[0];
            String team = input[1];
            if (!allUsers.contains(user)){
                if (!teams.containsKey(team)){
                    teams.put(team,new Team(user,new ArrayList<>()));
                    allUsers.add(user);
                    System.out.printf("Team %s has been created by %s!%n",team,user);
                }else{
                    System.out.printf("Team %s was already created!%n",team);
                }
            }else{
                System.out.printf("%s cannot create another team!%n",user);
            }
        }
        String line = scanner.nextLine();
        while (!line.equals("end of assignment")){
            String[] input = line.split("->");
            String user = input[0];
            String team = input[1];
            if (!teams.containsKey(team)){
                System.out.printf("Team %s does not exist!%n",team);
            }else {
                if (allUsers.contains(user)){
                    System.out.printf("Member %s cannot join team %s!%n",user,team);
                }else{
                    teams.get(team).getUsers().add(user);
                    allUsers.add(user);
                }
            }
            line = scanner.nextLine();
        }
        for (Team team:teams.values()
             ) {
            team.getUsers().sort((e1,e2)->{
                int best = e1.compareTo(e2);
                return best;
            });
        }
        teams.entrySet().stream().filter(e->e.getValue().getUsers().size()>0).sorted((e1,e2)->{
            int sizeCompare = Integer.compare(e2.getValue().getUsers().size(),e1.getValue().getUsers().size());
            return sizeCompare;
        })
        .forEach(e-> {
            System.out.println(e.getKey());
            System.out.println(e.getValue().toString());
            for (String user:e.getValue().getUsers()
                 ) {
                System.out.println("-- "+user);
            }
        });
        System.out.println("Teams to disband:");
        teams.entrySet().stream().filter(e->e.getValue().getUsers().isEmpty()).sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e-> System.out.println(e.getKey()));
    }
}
