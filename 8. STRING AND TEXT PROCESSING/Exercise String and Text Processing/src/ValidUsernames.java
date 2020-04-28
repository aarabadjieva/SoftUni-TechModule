import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            String pass = input[i];
            boolean isValid = isValid(pass);
            if (isValid){
                System.out.println(pass);
            }
        }
    }
    public static boolean isValid(String pass){
        if (pass.length()<3||pass.length()>16){
            return false;
        }
        for (int j = 0; j < pass.length(); j++) {
            char symbol = pass.charAt(j);
            if (!Character.isLetter(symbol)&&!Character.isDigit(symbol)&&symbol!='_'&&symbol!='-'){
                return false;
            }
        }
        return true;
    }
}
