import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymosThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> threat = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("3:1")){
            String[] cmd = line.split("\\s+");
            if (cmd[0].equals("merge")){
                int startIndex = Math.max(Integer.parseInt(cmd[1]),0);
                startIndex =Math.min(startIndex,threat.size()-1);
                int endIndex = Math.min(Integer.parseInt(cmd[2]),threat.size()-1);
                endIndex=Math.max(endIndex,0);
                for (int i = startIndex; i <endIndex ; i++) {
                    threat.set(startIndex,threat.get(startIndex)+threat.get(startIndex+1));
                    threat.remove(startIndex+1);
                }
            }else {
                int index = Integer.parseInt(cmd[1]);
                int parts = Integer.parseInt(cmd[2]);
                    String toDivide = threat.get(index);
                    int indexCounter = index;
                    int lenght = toDivide.length()/parts;
                    int counter = 0;
                   while (counter<parts-1){
                       String temp = toDivide.substring(0,lenght);
                       threat.add(indexCounter,temp);
                       indexCounter++;
                       toDivide =toDivide.substring(lenght,toDivide.length());
                       counter++;
                   }
                   threat.set(indexCounter,toDivide);
            }
            line = scanner.nextLine();
        }
        threat.forEach(e-> System.out.print(e+" "));
    }
}
