import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> result = new LinkedHashMap<>();
        while (!resource.equals("stop")){
            int value = Integer.parseInt(scanner.nextLine());
            result.putIfAbsent(resource,0);
            result.put(resource,result.get(resource)+value);
            resource=scanner.nextLine();
        }
        for (Map.Entry<String,Integer> entry:result.entrySet()
             ) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
