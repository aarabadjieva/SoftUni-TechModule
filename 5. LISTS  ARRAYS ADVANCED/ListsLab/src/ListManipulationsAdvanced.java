import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationsAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].toLowerCase().equals("end")){
            switch (command[0].toLowerCase()){
                case "contains":
                  if (numbers.contains(Integer.valueOf(command[1]))){
                      System.out.println("Yes");
                  }else{
                      System.out.println("No such number");
                  }
                    break;
                case "print":
                    if (command[1].equals("even")){
                      numbers.stream().filter(n ->n%2==0 )
                              .forEach(n-> System.out.print(n+" "));
                    }else if (command[1].equals("odd")){
                        numbers.stream().filter(n ->n%2!=0 )
                                .forEach(n-> System.out.print(n+" "));
                    }
                    System.out.println();
                    break;
                case "get":
                    numbers.stream().reduce((e1, e2) -> e1 + e2).ifPresent(System.out::println);
                    break;
                case "filter":
                    int number = Integer.valueOf(command[2]);
                    if (command[1].equals(">")){
                       numbers.stream().filter(e->e>number)
                               .forEach(e -> System.out.print(e+" "));
                    }else if (command[1].equals(">=")){
                        numbers.stream().filter(e->e>=number)
                                .forEach(e -> System.out.print(e+" "));
                    }else if (command[1].equals("<")){
                        numbers.stream().filter(e->e<number)
                                .forEach(e -> System.out.print(e+" "));
                    }else if (command[1].equals("<=")){
                        numbers.stream().filter(e->e<=number)
                                .forEach(e -> System.out.print(e+" "));
                    }
                    System.out.println();
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
    }
}
