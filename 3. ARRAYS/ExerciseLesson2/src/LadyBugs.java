import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeField = Integer.parseInt(scanner.nextLine());
        String[] field = new String[sizeField];
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (Integer.parseInt(input[i])>=0&&Integer.parseInt(input[i])<sizeField)
            field[Integer.parseInt(input[i])] = "1";
        }
        String[] direction = scanner.nextLine().split(" ");
        while (!direction[0].equals("end")) {
            for (int i = 0; i < field.length; i++) {
                if (Integer.parseInt(direction[0]) == i) {
                    if (field[i]==null){
                        break;
                    }
                    if (field[i].equals("1")) {
                        field[i] = "0";
                        if (direction[1].equals("left")) {
                            int x = Integer.parseInt(direction[2]);
                                for (int j = i - x; j >= 0&&j<field.length; j-=x) {
                                    if (field[j] == null || field[j].equals("0")) {
                                        field[j] = "1";
                                        break;
                                    } else {
                                    }
                                }

                        } else if (direction[1].equals("right")) {
                            int x = Integer.parseInt(direction[2]);
                                for (int j = i + x; j < field.length&&j>=0; j+=x) {
                                    if (field[j] == null || field[j].equals("0")) {
                                        field[j] = "1";
                                        break;
                                    } else {

                                    }
                                }

                        }
                    }
                }
            }


            direction = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < field.length; i++) {
            if (field[i] == null) {
                field[i] = "0";
            }
        }
        for (String index : field
        ) {
            System.out.print(index + " ");
        }

    }
}
