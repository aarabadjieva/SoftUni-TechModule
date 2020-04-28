import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("Retire!")) {
            List<String> cmd = Arrays.stream(line.split(" - ")).collect(Collectors.toList());
            switch (cmd.get(0)) {
                case "Start":
                    String quest = cmd.get(1);
                    if (!journal.contains(quest)) {
                        journal.add(quest);
                    }
                    break;
                case "Complete":
                    String questToRemove = cmd.get(1);
                    if (journal.contains(questToRemove)){
                        journal.remove(questToRemove);
                    }
                    break;
                case "Side Quest":
                    List<String> side = Arrays.stream(cmd.get(1).split(":")).collect(Collectors.toList());
                    String checkQuest = side.get(0);
                    String sideQuest = side.get(1);
                    if (journal.contains(checkQuest)){
                        if (!journal.contains(sideQuest)){
                            int index = journal.indexOf(checkQuest);
                            journal.add(index+1,sideQuest);
                        }
                    }
                    break;
                case "Renew":
                    String questToChange = cmd.get(1);
                    if (journal.contains(questToChange)){
                        journal.remove(questToChange);
                        journal.add(questToChange);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        if (journal.size()>1) {
            for (int i = 0; i < journal.size() - 1; i++) {
                System.out.print(journal.get(i) + ", ");
            }
        }
        System.out.print(journal.get(journal.size()-1));
    }
}
