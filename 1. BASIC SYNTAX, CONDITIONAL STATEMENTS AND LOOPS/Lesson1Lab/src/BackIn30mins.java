import java.util.Scanner;

public class BackIn30mins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int min = minutes + 30;
        if (min < 60) {
            System.out.printf("%d:%d",hours,min);
        }else{
            min = min-60;
            hours++;
            if (hours==24){
                hours=0;
            }
            if (min<10){
                System.out.printf("%d:0%d",hours,min);
            }else{
                System.out.printf("%d:%d",hours,min);
            }
        }
    }
}