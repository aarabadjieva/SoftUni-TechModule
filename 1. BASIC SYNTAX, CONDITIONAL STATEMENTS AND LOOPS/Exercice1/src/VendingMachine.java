import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = 0;
        String input = scanner.nextLine();
        String purchase;
        do {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                money += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("Start"));
        {
            do{ purchase = scanner.nextLine();
            double price;
            if ("Nuts".equals(purchase)) {
                price = 2;
                if (money >= price) {
                    System.out.println("Purchased Nuts");
                    money = money - price;
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if ("Water".equals(purchase)) {
                price = 0.7;
                if (money >= price) {
                    System.out.println("Purchased Water");
                    money = money - price;
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if ("Crisps".equals(purchase)) {
                price = 1.5;
                if (money >= price) {
                    System.out.println("Purchased Crisps");
                    money = money - price;
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if ("Soda".equals(purchase)) {
                price = 0.8;
                if (money >= price) {
                    System.out.println("Purchased Soda");
                    money = money - price;
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if ("Coke".equals(purchase)) {
                price = 1.00;
                if (money >= price) {
                    System.out.println("Purchased Coke");
                    money = money - price;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }else if (!purchase.equals("End")){
                System.out.println("Invalid product");

            }
            }while (!purchase.equals("End")) ;{
                System.out.printf("Change: %.2f", money);
            }

        }
    }

}

