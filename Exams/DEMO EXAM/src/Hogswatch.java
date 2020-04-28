import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hogswatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int homes  = Integer.parseInt(scanner.nextLine());
        int presents = Integer.parseInt(scanner.nextLine());
        int initial = presents;
        List<Integer> visited = new ArrayList<>();
        int goingBack = 0;
        List<Integer> additionalPresents = new ArrayList<>();
        int neededPresents = 0;
        int remainingHomes = homes;
        while (remainingHomes>0){
            neededPresents = Integer.parseInt(scanner.nextLine());
            visited.add(neededPresents);
            remainingHomes--;
            if (neededPresents<=presents){
                presents-=neededPresents;
            }else{
                int diff= neededPresents-presents;
                presents = (initial/visited.size())*(remainingHomes)+diff;
                goingBack++;
                additionalPresents.add(presents);
                presents-=diff;
            }
        }
        if (additionalPresents.isEmpty()){
            System.out.println(presents);
        }else{
            System.out.println(additionalPresents.size());
            int sum = 0;
            for (int i = 0; i <additionalPresents.size() ; i++) {
                sum+=additionalPresents.get(i);
            }
            System.out.println(sum);
        }
    }
}
