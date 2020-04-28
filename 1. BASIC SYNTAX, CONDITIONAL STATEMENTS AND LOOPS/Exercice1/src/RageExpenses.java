import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostgames = Integer.parseInt(scanner.nextLine());
        double headset = Double.parseDouble(scanner.nextLine());
        double mouse = Double.parseDouble(scanner.nextLine());
        double keyboard = Double.parseDouble(scanner.nextLine());
        double display = Double.parseDouble(scanner.nextLine());
        double h = 0;
        double m = 0;
        double k = 0;
        double d = 0;
        double all = 0;

        for (int i = lostgames; i >0; i--) {
            if (i % 6 == 0) {
                h++;
                m++;
                k++;
                all++;
            } else if (i % 3 == 0) {
                m++;
            } else if (i % 2 == 0) {
                h++;
            }
        }
        d=Math.floor(all/2);
        double money = h*headset+m*mouse+k*keyboard+d*display;
        System.out.printf("Rage expenses: %.2f lv.",money);
    }
}
