import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, List<String>> forceUsers = new LinkedHashMap<>();
        while (!line.equals("Lumpawaroo")) {
            if (line.contains(" | ")){
            String[] input = line.split("\\s\\|\\s");
                String side = input[0];
                String user = input[1];
                if (!forceUsers.containsKey(side)){
                    forceUsers.put(side,new ArrayList<>());
                }
                boolean flag = true;
                for (Map.Entry<String,List<String>>entry:forceUsers.entrySet()
                     ) {
                    if (entry.getValue().contains(user)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    forceUsers.get(side).add(user);
                }
            } else if (line.contains("->")){
                String[] input = line.split(" -> ");
                String side = input[1];
                String user = input[0];
                if (!forceUsers.containsKey(side)){
                    forceUsers.put(side,new ArrayList<>());
                }
                for (Map.Entry<String, List<String>>entry:forceUsers.entrySet()
                     ) {
                    if (entry.getValue().contains(user)){
                        entry.getValue().remove(user);
                        break;
                    }
                }
                forceUsers.get(side).add(user);
                System.out.println(user + " joins the "+side+" side!");
            }
            line = scanner.nextLine();
        }
        forceUsers.entrySet().stream().sorted((e1,e2)->{
            int compare = Integer.compare(e2.getValue().size(),e1.getValue().size());
            if (compare==0){
                compare = e1.getKey().compareTo(e2.getKey());
                return compare;
            }
            return compare;
        }).forEach(e->{
            Collections.sort(e.getValue());
            int size = e.getValue().size();
            if (size>0) {
                System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                for (String name : e.getValue()) {
                    System.out.printf("! %s%n", name);
                }
            }
        });
    }
}
