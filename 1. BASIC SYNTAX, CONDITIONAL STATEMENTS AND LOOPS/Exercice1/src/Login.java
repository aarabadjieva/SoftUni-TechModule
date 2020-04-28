import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder();

        for (int i = username.length()-1; i >=0 ; i--) {
            password.append(username.charAt(i));
        }
        for (int i = 0; i <4 ; i++) {
            String pass = scanner.nextLine();

            if (pass.equals(password.toString())) {
                System.out.printf("User %s logged in.", username);
                break;
            }else if (i == 3) {
                System.out.printf("User %s blocked!", username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }

        }

    }
}
