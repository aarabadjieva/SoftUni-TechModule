import java.util.Scanner;

public class BakingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());
        String flour = "1";
        String egg = "2";
        String apron = "3";
        double totalFlour = getTotalPrice(students,flourPrice,flour);
        double totalEggs = getTotalPrice(students,eggPrice,egg);
        double totalAprons = getTotalPrice(students,apronPrice,apron);
        double totalPrice = totalAprons+totalEggs+totalFlour;
        if (totalPrice<=budget){
            System.out.printf("Items purchased for %.2f$.",totalPrice);
        }else{
            double diff = totalPrice-budget;
            System.out.printf("%.2f$ more needed.",diff);
        }
    }

    private static double getTotalPrice(int students, double price, String product) {
        double totalPrice = 0;
        if (product.equals("1")){
            totalPrice = (students-students/5)*price;
        }else if (product.equals("2")){
            totalPrice = students*price*10;
        }else{
            double more = Math.ceil(students*0.2);
            totalPrice = (students+more)*price;
        }
        return totalPrice;
    }
}
