import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();
        while (count>0){
            String[] request = scanner.nextLine().split("\\s+");
            String name = request[0];
            String answer = request[2];
            if (answer.equals("going!")){
                if (names.contains(name)){
                    System.out.println(name+" is already in the list!");
                }else{
                    names.add(name);
                }
            }else {
                if (names.contains(name)){
                    names.remove(name);
                }else {
                    System.out.println(name+" is not in the list!");
                }
            }
            count--;
        }
        names.forEach(e-> System.out.println(e));
    }
}
