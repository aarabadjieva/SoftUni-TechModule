import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            char[] symbols = input[i].toCharArray();
            char firstLetter = symbols[0];
            char secondLetter = symbols[symbols.length-1];
            String number = "";
            for (int j = 1; j < symbols.length-1; j++) {
                number+=symbols[j];
            }
            double num = Double.parseDouble(number);
            if (Character.isUpperCase(firstLetter)){
                double position = firstLetter-64;
                num = num/position;
            }else{
                double position = firstLetter-96;
                num = num*position;
            }
            if (Character.isUpperCase(secondLetter)){
                double position = secondLetter-64;
                num-=position;
            }else{
                double position = secondLetter-96;
                num+=position;
            }
            sum+=num;
        }
        System.out.printf("%.2f",sum);
    }
}
