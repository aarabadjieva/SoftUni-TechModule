import java.util.Scanner;

public class ExtractPersonsInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String info = scanner.nextLine();
            String name = info.substring(info.indexOf("@")+1,info.indexOf("|"));
            String age = info.substring(info.indexOf("#")+1,info.indexOf("*"));
            System.out.printf("%s is %s years old.%n",name,age);
        }

    }
}
