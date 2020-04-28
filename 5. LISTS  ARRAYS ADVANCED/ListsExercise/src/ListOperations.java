import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] commands = line.split("\\s+");
            String cmd = commands[0];
            switch (cmd){
                case "Add":
                    int number = Integer.parseInt(commands[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    int digit = Integer.parseInt(commands[1]);
                    int indexToInsert = Integer.parseInt(commands[2]);
                    if (indexToInsert>=0&indexToInsert<numbers.size()){
                        numbers.add(indexToInsert,digit);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (indexToRemove>=0&indexToRemove<numbers.size()){
                        numbers.remove(indexToRemove);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commands[1];
                    int count = Integer.parseInt(commands[2]);
                    if (direction.equals("left")){
                        for (int i = 0; i < count; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    }else{
                        for (int i = 0; i < count; i++) {
                            numbers.add(0,numbers.get(numbers.size()-1));
                            numbers.remove(numbers.size()-1);
                        }
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        numbers.forEach(e-> System.out.print(e+" "));
    }
}
