import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();
        double price = 0;
        double totalPrice = 0;

        switch (type) {
            case "students":
                switch (day) {
                    case "friday":
                        price = 8.45;
                        break;
                    case "saturday":
                        price = 9.80;
                        break;
                    case "sunday":
                        price = 10.46;
                        break;
                }
                totalPrice = price * group;
                if (group >= 30) {
                    totalPrice = totalPrice - totalPrice * 0.15;
                }
                break;
            case "business":
                switch (day) {
                    case "friday":
                        price = 10.90;
                        break;
                    case "saturday":
                        price = 15.60;
                        break;
                    case "sunday":
                        price = 16;
                        break;
                }
                if (group >= 100) {
                    group -= 10;
                }
                totalPrice = price * group;
                break;
            case "regular":
                switch (day) {
                    case "friday":
                        price = 15;
                        break;
                    case "saturday":
                        price = 20;
                        break;
                    case "sunday":
                        price = 22.50;
                        break;
                }
                totalPrice = price * group;
                if (group >= 10 && group <= 20) {
                    totalPrice = totalPrice - totalPrice * 0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
