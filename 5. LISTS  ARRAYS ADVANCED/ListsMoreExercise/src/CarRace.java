import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> times = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double left = 0;
        double right = 0;
        for (int i = 0; i < times.size()/2; i++) {
            left+=times.get(i);
            if (times.get(i)==0){
                left -= left*0.2;
            }
        }
        for (int i = times.size()-1; i >times.size()/2 ; i--) {
            right+=times.get(i);
            if (times.get(i)==0){
                right -= right*0.2;
            }
        }
        double endTime = Math.min(left,right);
        String winner = "";
        if (endTime==right){
            winner+="right";
        }else{
            winner+="left";
        }
        System.out.printf("The winner is %s with total time: %.1f",winner,endTime);
    }
}
