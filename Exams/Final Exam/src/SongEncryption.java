import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("end")){
            String[] input = line.split(":");
            Pattern artistName = Pattern.compile("^[A-Z][a-z' ]+(?!.)");
            Pattern songName = Pattern.compile("^[A-Z ]+(?!.)");
            Matcher artistMatcher = artistName.matcher(input[0]);
            Matcher songMatcher = songName.matcher(input[1]);
            if (artistMatcher.find()){
                if (songMatcher.find()){
                    int key = artistMatcher.group().length();
                    StringBuilder encryptedSong = new StringBuilder();
                    char[] symbols = line.toCharArray();
                    for (int i = 0; i < symbols.length; i++) {
                        char temp = symbols[i];
                        if (temp==' '||temp=='\''){
                            encryptedSong.append(temp);
                        }else if (temp==':'){
                            encryptedSong.append('@');
                        }else{
                            if (temp<'a'){
                                temp+=key;
                                if (temp>'Z'){
                                    temp -= 26;
                                }
                            }else {
                                temp+=key;
                                if (temp>'z'){
                                    temp -= 26;
                                }
                            }
                            encryptedSong.append(temp);
                        }
                    }
                    System.out.printf("Successful encryption: %s%n",encryptedSong.toString());
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
            line = scanner.nextLine();
        }
    }
}
