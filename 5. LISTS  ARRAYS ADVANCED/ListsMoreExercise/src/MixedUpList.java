import java.util.*;
import java.util.stream.Collectors;

public class MixedUpList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        while (!first.isEmpty()&&!second.isEmpty()) {
            result.add(first.get(0));
            first.remove(0);
            result.add(second.get(second.size() - 1));
            second.remove(second.size() - 1);
        }
        int begining = 0;
        int end = 0;
        if (!first.isEmpty()) {
            begining = Math.min(first.get(0), first.get(1));
            end = Math.max(first.get(0), first.get(1));
        }else {
            begining = Math.min(second.get(0), second.get(1));
            end = Math.max(second.get(0), second.get(1));
        }
        Collections.sort(result);
        for (int num:result
             ) {
            if (num>begining&&num<end){
                System.out.print(num+" ");
            }
        }
    }
}
