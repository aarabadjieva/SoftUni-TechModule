import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String input = scan.nextLine();
            if (input.equals("END")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                System.out.printf("%s is integer type\n",input);
                continue;
            }catch (NumberFormatException e){}
            try {
                double number = Double.parseDouble(input);
                System.out.printf("%s is floating point type\n",input);
                continue;
            }catch (NumberFormatException e){}
            try {
                if (input.length()==1){
                    System.out.printf("%s is character type\n",input);
                }else if (input.equalsIgnoreCase("true")||input.equalsIgnoreCase("false")){
                    System.out.printf("%s is boolean type\n",input);
                }else{
                    System.out.printf("%s is string type\n",input);
                }
            }catch (NumberFormatException e){}
        }
    }
}
