import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age >= 0 && age <= 18) {
            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 5;
                    break;
            }
            System.out.println(price + "$");
        } else if (age > 18 && age <= 64) {
            switch (day) {
                case "weekday":
                    price = 18;
                    break;
                case "weekend":
                    price = 20;
                    break;
                case "holiday":
                    price = 12;
                    break;
            }
            System.out.println(price + "$");
        } else if (age > 64 && age <= 122) {
            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 10;
                    break;
            }
            System.out.println(price + "$");
        } else {
            System.out.println("Error!");
        }
    }
}