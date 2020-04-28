import java.util.Scanner;

public class ReverseArrayString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String reversed = "";
        int div = 1;

        for (int i = 0; i <array.length/2 ; i++) {
            String change = array[i];
            array[i]=array[array.length-div];
            array[array.length-div] =change;
            div++;
        }
        for (int j = 0; j < array.length; j++) {
            if (j==0){
                reversed = reversed+array[j];
            }else {
                reversed = reversed + " " + array[j];
            }
        }
        System.out.println(reversed);
    }
}
