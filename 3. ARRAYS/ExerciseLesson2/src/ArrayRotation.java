import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int rotate = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rotate; i++) {
            String element = array[0];
            for (int j = 0; j <array.length ; j++) {

                if (j<array.length-1) {
                    array[j] = array[j + 1];
                }else {
                    array[array.length-1]=element;
                }
            }
        }
        for (String element:array
             ) {
            System.out.print(element+" ");
        }
    }//1 2 3
    //223
}
