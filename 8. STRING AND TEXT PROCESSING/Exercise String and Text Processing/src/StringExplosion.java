import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String explosive = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < explosive.length(); i++) {
            char symbol = explosive.charAt(i);
            result.append(symbol);
            if (symbol=='>'){
                i++;
                int power = explosive.charAt(i)-'0';
                power--;
               while (power>0){
                   i++;
                   if (i==explosive.length()){
                       break;
                   }
                   symbol = explosive.charAt(i);
                   if (symbol=='>'){
                       result.append(symbol);
                       i++;
                       if (i==explosive.length()){
                           break;
                       }
                       power--;
                       power+=explosive.charAt(i)-'0';
                   }else {
                       power--;
                   }
               }
            }
        }
        System.out.println(result);
    }
}
