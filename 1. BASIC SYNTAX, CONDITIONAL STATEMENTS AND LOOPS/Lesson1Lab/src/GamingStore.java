import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cash = Double.parseDouble(scanner.nextLine());
        double price = 0;
        String input = scanner.nextLine();
        double spent = 0;
        do {
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not found");
                    break;
            }
            if (cash>=price){
                System.out.printf("Bought %s\n",input);
                cash-=price;
                if (cash==0){
                    System.out.println("Out of money!");
                }
                spent+=price;
            }else if (cash<price){
                System.out.println("Too Expensive");
            }
            input=scanner.nextLine();
        }while (!input.equals("Game Time"));{
            if (cash>0) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, cash);
            }
        }
    }
}
