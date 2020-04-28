import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startingYield = Integer.parseInt(scanner.nextLine());
        long storage = 0;
        int days=0;
        while (startingYield>=100){
            storage+=startingYield-26;
            startingYield-=10;
            days++;
        }
        long totalExtracted = storage;
        if (totalExtracted>=26) {
            totalExtracted = storage - 26;
        }
        System.out.println(days);
        System.out.println(totalExtracted);
    }
}
