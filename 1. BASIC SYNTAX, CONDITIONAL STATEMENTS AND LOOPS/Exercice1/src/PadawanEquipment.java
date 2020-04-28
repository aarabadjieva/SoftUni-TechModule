import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cash = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaber = Double.parseDouble(scanner.nextLine());
        double robe = Double.parseDouble(scanner.nextLine());
        double belt = Double.parseDouble(scanner.nextLine());
        double lsbNeeded = Math.ceil(students+students*0.1);
        double bNeeded = students-Math.floor(students/6);
        double money = lsbNeeded*lightSaber+students*robe+bNeeded*belt;
        if (cash>=money){
            System.out.printf("The money is enough - it would cost %.2flv.",money);
        }else{
            double diff = money - cash;
            System.out.printf("Ivan Cho will need %.2flv more.",diff);
        }

    }
}
