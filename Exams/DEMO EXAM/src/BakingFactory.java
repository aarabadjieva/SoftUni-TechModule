import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BakingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int bestQuality = Integer.MIN_VALUE;
        double bestAverage = Integer.MIN_VALUE;
        int bestSize = Integer.MAX_VALUE;
        List<Integer> best = new ArrayList<>();
        while (!line.equals("Bake It!")){
           List<Integer> bread = Arrays.stream(line.split("#"))
                   .map(Integer::parseInt)
                   .collect(Collectors.toList());
           int quality = 0;
           int size = bread.size();
            for (int i = 0; i <bread.size() ; i++) {
                quality+=bread.get(i);
            }
            double average = quality/(size*1.00);
            if (quality>bestQuality){
                bestQuality=quality;
                bestAverage=average;
                bestSize=size;
                best=bread;
            }else if (quality==bestQuality){
                if (average>bestAverage){
                    bestQuality=quality;
                    bestAverage=average;
                    bestSize=size;
                    best=bread;
                }else if (average==bestAverage){
                    if (size<bestSize){
                        bestQuality=quality;
                        bestAverage=average;
                        bestSize=size;
                        best=bread;
                    }
                }
            }
            line = scanner.nextLine();
        }
        System.out.println("Best Batch quality: "+bestQuality);
        best.forEach(e-> System.out.print(e+" "));
    }
}
