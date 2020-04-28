import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuri = Integer.parseInt(scanner.nextLine());

        int years = centuri*100;
        int days = (int) (years*365.2422);
        int hours = days*24;
        int minutes = hours*60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes",
                centuri,years,days,hours,minutes);
    }
}
