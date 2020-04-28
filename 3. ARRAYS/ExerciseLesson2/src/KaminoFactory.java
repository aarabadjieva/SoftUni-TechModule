import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] dna = scanner.nextLine().split("!+");
        int[] sequence = new int[length];
        int sequenceNumber = 0;
        int longest = 0;
        int firstIndex = Integer.MAX_VALUE-1;
        int bestSum = 0;
        int[] best = new int[sequence.length];
        int currSequenceNum = 1;
        while (!dna[0].equals("Clone them")) {
            for (int i = 0; i < dna.length; i++) {
                String num = dna[i];
                sequence[i] = Integer.parseInt(num);
            }

            for (int i = 0; i < sequence.length; i++) {
                int currLongest = 0;
                int currIndex = i;
                int currSum = 0;
                if (sequence[i] == 1) {
                    currLongest++;
                    currIndex = i;
                    for (int j = i + 1; j < sequence.length; j++) {
                        if (sequence[i] == sequence[j]) {
                            currLongest++;
                            currIndex = i;
                        } else {
                            currLongest++;
                            currIndex = i;
                            break;
                        }
                    }
                }
                    if (currLongest > longest) {
                        longest = currLongest;
                        firstIndex = currIndex;
                        for (int j = 0; j < sequence.length; j++) {
                            currSum += sequence[j];
                        }
                        bestSum = currSum;
                        sequenceNumber = currSequenceNum;
                        for (int m = 0; m < sequence.length; m++) {
                            best[m] = sequence[m];
                        }
                    } else if (currLongest == longest) {
                        if (firstIndex > currIndex) {
                            longest = currLongest;
                            firstIndex = currIndex;
                            for (int j = 0; j < sequence.length; j++) {
                                currSum += sequence[j];
                            }
                            for (int m = 0; m < sequence.length; m++) {
                                best[m] = sequence[m];
                            }
                            bestSum = currSum;
                            sequenceNumber = currSequenceNum;
                        } else if (firstIndex == currIndex) {
                            for (int j = 0; j < sequence.length; j++) {
                                currSum += sequence[j];
                            }
                            if (bestSum < currSum) {
                                longest = currLongest;
                                firstIndex = currIndex;
                                bestSum = currSum;
                                sequenceNumber = currSequenceNum;
                                for (int m = 0; m < sequence.length; m++) {
                                    best[m] = sequence[m];
                                }
                            }
                        }
                    }
            }
            dna = scanner.nextLine().split("!+");
            currSequenceNum++;
        }
        System.out.printf("Best DNA sample %d with sum: %d.", sequenceNumber, bestSum);
        System.out.println();
        for (int num : best
        ) {
            System.out.print(num + " ");
        }
    }
}