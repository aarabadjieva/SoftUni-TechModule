import java.util.Scanner;

public class ForeinLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine().toLowerCase();
        if (country.equals("england")||country.equals("usa")){
            System.out.println("English");
        }else if (country.equals("spain")||country.equals("argentina")||country.equals("mexico")){
            System.out.println("Spanish");
        }else{
            System.out.println("unknown");
        }
    }
}
