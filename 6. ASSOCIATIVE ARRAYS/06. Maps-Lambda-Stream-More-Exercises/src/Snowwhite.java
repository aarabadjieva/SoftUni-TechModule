import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Integer> allDwarfs = new LinkedHashMap<>();
        Map<String, Integer> hatsCount = new LinkedHashMap<>();
        while (!line.equals("Once upon a time")){
            String[] input = line.split(" <:> ");
            String nameColour = input[0]+" "+input[1];
            String color = input[1];
            int strenght = Integer.parseInt(input[2]);
           if (!allDwarfs.containsKey(nameColour)){
               allDwarfs.put(nameColour,strenght);
               if (!hatsCount.containsKey(color)){
                   hatsCount.put(color,1);
               }else{
                   hatsCount.put(color,hatsCount.get(color)+1);
               }
           }else{
               allDwarfs.put(nameColour,Math.max(allDwarfs.get(nameColour),strenght));
           }
            line=scanner.nextLine();
        }
        allDwarfs.entrySet().stream().sorted((e1,e2)->{
            int compare = Integer.compare(e2.getValue(),e1.getValue());
            if (compare==0){
                String cl1 = e1.getKey().split(" ")[1];
                String cl2 = e2.getKey().split(" ")[1];
                int count1 = hatsCount.get(cl1);
                int count2 = hatsCount.get(cl2);
                compare = Integer.compare(count2,count1);
                return compare;
            }
            return compare;
        }).forEach(e->
                System.out.printf("(%s) %s <-> %d%n",e.getKey().split(" ")[1],e.getKey().split(" ")[0],e.getValue()));
    }
}
