import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long pokePower = Integer.parseInt(scanner.nextLine());
        long distance = Integer.parseInt(scanner.nextLine());
        int exhaustion = Integer.parseInt(scanner.nextLine());
        int targets = 0;
        long currentPokePower = pokePower;
        while (currentPokePower >= distance) {
            targets++;
            currentPokePower -= distance;
            if (currentPokePower == pokePower / 2.00) {
                if ((currentPokePower >= exhaustion) && (exhaustion != 0)) {
                    currentPokePower = currentPokePower / exhaustion;
                }
            }
        }
        System.out.println(currentPokePower);
        System.out.println(targets);
    }
}
