import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distance = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum=0;
        while (!distance.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());
            if (index>=0&&index<distance.size()) {
                int element = distance.get(index);
                sum+=element;
                distance.remove(index);
              changeListElements(distance,element);
            }else if (index<0){
                int element = distance.get(0);
                sum+=element;
                distance.set(0,distance.get(distance.size()-1));
                changeListElements(distance,element);
            }else{
                int element = distance.get(distance.size()-1);
                sum+=element;
                distance.set(distance.size()-1,distance.get(0));
                changeListElements(distance,element);
            }
        }
        System.out.println(sum);
    }

    private static void changeListElements(List<Integer> distance, int element) {
        for (int i = 0; i < distance.size(); i++) {
            if (distance.get(i)<=element){
                distance.set(i,distance.get(i)+element);
            }else{
                distance.set(i,distance.get(i)-element);
            }
        }
    }
}
