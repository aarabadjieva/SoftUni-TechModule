import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> symbols = new ArrayList<>((Arrays.asList(input.split(""))));
        List<Integer> digits = new ArrayList<>();
        int size = symbols.size()-1;
        for (int i = size; i >= 0; i--) {
            String current = symbols.get(i);
            if (current.charAt(0)>=48&&current.charAt(0)<=57){
                digits.add(0,Integer.parseInt(current));
                symbols.remove(i);
            }
        }
        List<Integer> takeList = findEvenIndex(digits);
        List<Integer> skipList = findOddIndex(digits);
        String result = "";
        int countSymbols = 0;
        int temp = 0;
        while (countSymbols<symbols.size()&&temp<takeList.size()) {
            for (int i = 0; i < takeList.size(); i++) {
                for (int j = 0; j < takeList.get(i); j++) {
                    result += symbols.get(countSymbols);
                    countSymbols++;
                    if (countSymbols>=symbols.size()){
                        break;
                    }
                }
                countSymbols+=skipList.get(i);
                temp++;
            }
        }
        System.out.println(result);
    }

    private static List<Integer> findOddIndex(List<Integer> digits) {
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            if (i%2!=0){
                odd.add(digits.get(i));
            }
        }
        return odd;
    }

    private static List<Integer> findEvenIndex(List<Integer> digits) {
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            if (i%2==0){
                even.add(digits.get(i));
            }
        }
        return even;
    }

}
