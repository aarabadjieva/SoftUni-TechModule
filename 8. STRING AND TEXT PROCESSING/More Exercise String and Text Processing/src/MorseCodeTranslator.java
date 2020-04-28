import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String temp = input[i];
            if (temp.equals(".-")){
                temp = "A";
            }else if (temp.equals("-...")){
                temp = "B";
            }else if (temp.equals("-.-.")){
                temp = "C";
            }else if (temp.equals("-..")){
                temp = "D";
            }else if (temp.equals(".")){
                temp = "E";
            }else if (temp.equals("..-.")){
                temp = "F";
            }else if (temp.equals("--.")){
                temp = "G";
            }else if (temp.equals("....")){
                temp = "H";
            }else if (temp.equals("..")){
                temp = "I";
            }else if (temp.equals(".---")){
                temp = "J";
            }else if (temp.equals("-.-")){
                temp = "K";
            }else if (temp.equals(".-..")){
                temp = "L";
            }else if (temp.equals("--")){
                temp = "M";
            }else if (temp.equals("-.")){
                temp = "N";
            }else if (temp.equals("---")){
                temp = "O";
            }else if (temp.equals(".--.")){
                temp = "P";
            }else if (temp.equals("--.-")){
                temp = "Q";
            }else if (temp.equals(".-.")){
                temp = "R";
            }else if (temp.equals("...")){
                temp = "S";
            }else if (temp.equals("-")){
                temp = "T";
            }else if (temp.equals("..-")){
                temp = "U";
            }else if (temp.equals("...-")){
                temp = "V";
            }else if (temp.equals(".--")){
                temp = "W";
            }else if (temp.equals("-..-")){
                temp = "X";
            }else if (temp.equals("-.--")){
                temp = "Y";
            }else if (temp.equals("--..")){
                temp = "Z";
            }else if (temp.equals("|")){
                temp = " ";
            }
            message.append(temp);
        }
        System.out.println(message);
    }
}
