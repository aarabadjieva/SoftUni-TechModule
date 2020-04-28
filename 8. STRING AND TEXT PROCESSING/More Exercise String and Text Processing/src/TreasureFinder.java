import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> keys = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> messages = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("find")){
            String message = "";
            for (int i = 0; i < line.length(); i++) {
                char toChange = line.charAt(i);
                int key = 0;
                if (i<keys.size()){
                    key=keys.get(i);
                }else{
                    key = keys.get(i%keys.size());
                }
                toChange-=key;
                message+=toChange;
            }
            messages.add(message);
            line = scanner.nextLine();
        }
        messages.stream().forEach(e->{
            String type = e.substring(e.indexOf("&")+1,e.lastIndexOf("&"));
            String coordinates = e.substring(e.indexOf("<")+1,e.indexOf(">"));
            System.out.printf("Found %s at %s%n",type,coordinates);
        });
    }
}
