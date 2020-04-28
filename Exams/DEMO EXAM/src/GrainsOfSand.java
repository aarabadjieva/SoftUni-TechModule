import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> grains = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("Mort")){
            List<String> cmd = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());
            if (cmd.get(0).equals("Add")){
                int toAdd = Integer.parseInt(cmd.get(1));
                grains.add(toAdd);
            }else if (cmd.get(0).equals("Remove")){
                int number = Integer.parseInt(cmd.get(1));
                if (grains.contains(number)){
                    int index = grains.indexOf(number);
                    grains.remove(index);
                }else{
                    if (number>=0&&number<grains.size()){
                        grains.remove(number);
                    }
                }
            }else if (cmd.get(0).equals("Replace")){
                int number = Integer.parseInt(cmd.get(1));
                int replacement = Integer.parseInt(cmd.get(2));
                if (grains.contains(number)){
                    int index = grains.indexOf(number);
                    grains.set(index,replacement);
                }
            }else if (cmd.get(0).equals("Increase")){
                int value = Integer.parseInt(cmd.get(1));
                boolean isGreater = false;
                for (int i = 0; i <grains.size() ; i++) {
                    if (grains.get(i)>=value){
                        value=grains.get(i);
                        isGreater=true;
                        break;
                    }
                }
                if (!isGreater){
                    value = grains.get(grains.size()-1);
                }
                int finalValue = value;
                grains = grains.stream().map(e->e=e+finalValue).collect(Collectors.toList());
            }else{
                int value = Integer.parseInt(cmd.get(1));
                grains.removeIf(e->e<value);
            }
            line = scanner.nextLine();
        }
        grains.forEach(e-> System.out.print(e+" "));
    }
}
