import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int totalTime = 0;
        int dishTime = 0;
        int cleanTime = 0;
        int laundryTime=0;
        while (!input.equals("wife is happy")){
            Pattern dishes = Pattern.compile("(?<=<)([a-z]?\\d?)*(?=>)");
            Pattern cleaning = Pattern.compile("(?<=\\[)([A-Z]?\\d?)*(?=\\])");
            Pattern laundry = Pattern.compile("(?<=\\{).+(?=})");
            Matcher dishMatch = dishes.matcher(input);
            Matcher cleanMatch = cleaning.matcher(input);
            Matcher laundryMatch = laundry.matcher(input);
            if (dishMatch.find()){
                String text = dishMatch.group();
                for (int i = 0; i < text.length(); i++) {
                    try{
                        dishTime+=Integer.parseInt(String.valueOf(text.charAt(i)));
                    }catch (NumberFormatException e){
                        continue;
                    }
                }
            }else if (cleanMatch.find()){
                String text = cleanMatch.group();
                for (int i = 0; i < text.length(); i++) {
                    try{
                        cleanTime+=Integer.parseInt(String.valueOf(text.charAt(i)));
                    }catch (NumberFormatException e){
                        continue;
                    }
                }
            }else if (laundryMatch.find()){
                String text = laundryMatch.group();
                for (int i = 0; i < text.length(); i++) {
                    try{
                        laundryTime+=Integer.parseInt(String.valueOf(text.charAt(i)));
                    }catch (NumberFormatException e){
                        continue;
                    }
                }
            }
            input = scanner.nextLine();
        }
        totalTime = dishTime+cleanTime+laundryTime;
        System.out.printf("Doing the dishes - %d min.\n" +
                "Cleaning the house - %d min.\n" +
                "Doing the laundry - %d min.\n" +
                "Total - %d min. \n",dishTime,cleanTime,laundryTime,totalTime);
    }
}
