import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, String> contests = new LinkedHashMap<>();
        while (!line.equals("end of contests")){
            String[] contPass = line.split(":");
            String contest = contPass[0];
            String password = contPass[1];
            contests.put(contest,password);
            line = scanner.nextLine();
        }
        String line2 = scanner.nextLine();
        Map<String,Map<String,Integer>> studentPoints = new LinkedHashMap<>();
        while (!line2.equals("end of submissions")){
            String[] subbStudents = line2.split("=>");
            String contest = subbStudents[0];
            String password = subbStudents[1];
            String name = subbStudents[2];
            int points = Integer.parseInt(subbStudents[3]);
            if (contests.containsKey(contest)){
                if (contests.get(contest).equals(password)){
                    if (!studentPoints.containsKey(name)){
                        studentPoints.put(name,new LinkedHashMap<>());
                        studentPoints.get(name).put(contest,points);
                    }else {
                        if (!studentPoints.get(name).containsKey(contest)){
                            studentPoints.get(name).put(contest,points);
                        }else{
                            if (studentPoints.get(name).get(contest)<points){
                                studentPoints.get(name).replace(contest,points);
                            }
                        }
                    }
                }
            }
            line2 = scanner.nextLine();
        }
        int bestTotal = 0;
        String name = "";
        for (Map.Entry<String,Map<String,Integer>>entry:studentPoints.entrySet()
             ) {
            int total = 0;
            for (Map.Entry<String, Integer>input:entry.getValue().entrySet()){
                total+=input.getValue();
            }
            if (total>bestTotal){
                bestTotal=total;
                name = entry.getKey();
            }
        }
        System.out.println(String.format("Best candidate is %s with total %d points.",name,bestTotal));
        System.out.println("Ranking: ");
        studentPoints.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e->{
                    System.out.println(e.getKey());
                    e.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(cl -> {
                                System.out.printf("#  %s -> %d%n",cl.getKey(),cl.getValue());
                            });
                });
    }
}
