import java.util.Scanner;

public class GoogleSearches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDays = Integer.parseInt(scanner.nextLine());
        int users = Integer.parseInt(scanner.nextLine());
        double incomePerWord = Double.parseDouble(scanner.nextLine());
        double totalIncome = 0;
        for (int i = 1; i <= users; i++) {
            int words  = Integer.parseInt(scanner.nextLine());
            double incomePerUser = 0;
            if (words<=5){
                incomePerUser = words*incomePerWord;
                if (words==1){
                    incomePerUser=incomePerUser*2;
                }
                if (i%3==0){
                    incomePerUser = incomePerUser*3;
                }
            }
            totalIncome+=incomePerUser*totalDays;
        }

        System.out.printf("Total money earned for %d days: %.2f",totalDays,totalIncome);
    }
}
