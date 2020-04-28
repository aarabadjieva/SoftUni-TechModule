import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> userPlates = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] cmd = scanner.nextLine().split("\\s");
            String user = cmd[1];
            if (cmd[0].equals("register")){
                String plate = cmd[2];
                if (userPlates.containsKey(user)){
                    System.out.println("ERROR: already registered with plate number "+userPlates.get(user));
                }else {
                    userPlates.put(user,plate);
                    System.out.println(user+" registered "+plate+" successfully");
                }
            }else{
                if (!userPlates.containsKey(user)){
                    System.out.println("ERROR: user "+user+" not found");
                }else{
                    System.out.println(user+" unregistered successfully");
                    userPlates.remove(user);
                }
            }
        }
        userPlates.entrySet().forEach(e-> System.out.printf("%s => %s%n",e.getKey(),e.getValue()));
    }
}
