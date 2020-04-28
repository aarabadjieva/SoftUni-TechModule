import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courseNames = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("end")){
            String[] input = line.split(" : ");
            String course = input[0];
            String name = input[1];

            courseNames.putIfAbsent(course, new ArrayList<>());
            courseNames.get(course).add(name);
            line = scanner.nextLine();
        }
        courseNames.entrySet().stream().sorted(
                (e1,e2)->{
                    int compare = (int) Integer.compare(e2.getValue().size(),e1.getValue().size());
                    return compare;
                }).forEach(e-> {
            System.out.printf("%s: %d%n",e.getKey(),e.getValue().size(),e.getValue());
            Collections.sort(e.getValue());
            for (String student:e.getValue()
                 ) {
                System.out.println("-- "+student);
            }
        });
    }
}
