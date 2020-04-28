import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasiveSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] len = new int[nums.length];
        int[] prev = new int[nums.length];
        int maxLen = 0;
        int lastIndex = -1;
        for (int x = 0; x < nums.length; x++) {
            len[x] = 1;
            prev[x] = -1;
            for (int i = 0; i <= x - 1; i++) {
                if (nums[i] < nums[x] && len[i] + 1 > len[x]) {
                    len[x] = len[i] + 1;
                    prev[x] = i;
                }
                if (len[x] > maxLen) {
                    maxLen = len[x];
                    lastIndex = x;
                }
            }
        }
        int[] LIS = new int[maxLen];
        while(lastIndex!=-1){
            for (int i = LIS.length-1; i >=0; i--) {
                LIS[i] = nums[lastIndex];
                lastIndex=prev[lastIndex];
            }
        }
        for (int num:LIS
        ) {
            System.out.print(num+" ");
        }
    }
}
