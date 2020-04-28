import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = mergeLists(first,second);
        for (int num:result
             ) {
            System.out.print(num+" ");
        }
    }

    private static List<Integer> mergeLists(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>(first.size()+second.size());

        int temp = 0;
        int firstSize = first.size();
        int secondSize = second.size();
        for (int i = 0; i < Math.min(first.size(),second.size()); i++) {
            result.add(temp,first.get(i));
            firstSize--;
            temp++;
            result.add(temp,second.get(i));
            secondSize--;
            temp++;
        }
        if (firstSize>0){
            for (int i = second.size(); i <first.size() ; i++) {
                result.add(temp,first.get(i));
                temp++;
            }
        }
        if (secondSize>0){
            for (int i = first.size(); i <second.size() ; i++) {
                result.add(temp,second.get(i));
                temp++;
            }
        }
        return result;
    }
}
