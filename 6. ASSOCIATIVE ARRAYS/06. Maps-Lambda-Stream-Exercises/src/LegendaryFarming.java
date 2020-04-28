import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> legendary = new LinkedHashMap<>();
        legendary.put("Shadowmourne",0);
        legendary.put("Valanyr",0);
        legendary.put("Dragonwrath",0);
        Map<String, Integer> junk = new LinkedHashMap<>();
        Map<String, Integer> remaining = new LinkedHashMap<>();
        boolean obtained = false;
        while (!obtained){
            String[] input = scanner.nextLine().toLowerCase().split("\\s");
            for (int i = 1; i < input.length; i+=2) {
                int quantity = Integer.parseInt(input[i-1]);
                if (input[i].equals("shards")){
                    legendary.put("Shadowmourne",legendary.get("Shadowmourne")+quantity);
                    if (legendary.get("Shadowmourne")>=250){
                        int left = legendary.get("Shadowmourne")-250;
                        remaining.put("shards",left);
                        remaining.put("fragments",legendary.get("Valanyr"));
                        remaining.put("motes",legendary.get("Dragonwrath"));
                        obtained = true;
                        System.out.println("Shadowmourne obtained!");
                        break;
                    }
                }else if (input[i].equals("fragments")){
                    legendary.put("Valanyr",legendary.get("Valanyr")+quantity);
                    if (legendary.get("Valanyr")>=250){
                        int left = legendary.get("Valanyr")-250;
                        remaining.put("shards",legendary.get("Shadowmourne"));
                        remaining.put("fragments",left);
                        remaining.put("motes",legendary.get("Dragonwrath"));
                        obtained = true;
                        System.out.println("Valanyr obtained!");
                        break;
                    }
                }else if (input[i].equals("motes")){
                    legendary.put("Dragonwrath",legendary.get("Dragonwrath")+quantity);
                    if (legendary.get("Dragonwrath")>=250){
                        int left = legendary.get("Dragonwrath")-250;
                        remaining.put("shards",legendary.get("Shadowmourne"));
                        remaining.put("fragments",legendary.get("Valanyr"));
                        remaining.put("motes",left);
                        obtained = true;
                        System.out.println("Dragonwrath obtained!");
                        break;
                    }
                }else{
                    junk.putIfAbsent(input[i],0);
                    junk.put(input[i],junk.get(input[i])+quantity);
                }
            }
        }
        remaining.entrySet().stream().sorted((e1,e2)->{
            int valueCompare = Integer.compare(e2.getValue(),e1.getValue());
            if (valueCompare==0){
                return e1.getKey().compareTo(e2.getKey());
            }
            return valueCompare;
        }).forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
        junk.entrySet().stream().sorted(
                Comparator.comparing(Map.Entry::getKey)
        ).forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }
}
