import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String str1 = words[0];
        String str2 = words[1];
        sum(str1,str2);
    }
    public static void sum(String str1, String str2){
        int min = Math.min(str1.length(),str2.length());
        int totalSum = 0;
        for (int i = 0; i <min ; i++) {
            char first = str1.charAt(i);
            char second = str2.charAt(i);
            totalSum+=first*second;
        }
        String longer = str1;
        String shorter = str2;
        if (str1.length()<str2.length()){
            longer = str2;
            shorter = str1;
        }
        longer = longer.substring(shorter.length());
        if (longer.length()>0){
            for (int i = 0; i < longer.length(); i++) {
                char toAdd = longer.charAt(i);
                totalSum+=toAdd;
            }
        }
        System.out.println(totalSum);
    }
}
