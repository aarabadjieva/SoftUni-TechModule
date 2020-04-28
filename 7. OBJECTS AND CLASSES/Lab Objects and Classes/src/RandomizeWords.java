import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    static int randomWord(String[] words){
        Random rnd = new Random();
        int randomword = rnd.nextInt(words.length);
        return randomword;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            int result = randomWord(input);
            String toExchange = input[i];
            input[i] = input[result];
            input[result] = toExchange;
        }
        for (String word:input
             ) {
            System.out.println(word);
        }
    }
}
