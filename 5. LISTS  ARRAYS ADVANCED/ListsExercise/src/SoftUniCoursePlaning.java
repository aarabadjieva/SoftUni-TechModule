import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
      String line = scanner.nextLine();
      while (!line.equals("course start")){
          String[] cmd = line.split(":");
          String command = cmd[0];
          String title = cmd[1];
          switch (command){
              case "Add":
              if (!lessons.contains(title)) {
                  lessons.add(title);
              }
              break;
              case "Insert":
                if (!lessons.contains(title)){
                    int index = Integer.parseInt(cmd[2]);
                    lessons.add(index,title);
                }
                break;
              case "Remove":
                  if (lessons.contains(title)){
                      lessons.remove(title);
                  }
                  if (lessons.contains(title+"-Exercise")){
                      lessons.remove(title+"-Exercise");
                  }
                  break;
              case "Swap":
                  String title2 = cmd[2];
                 if (lessons.contains(title)&&lessons.contains(title2)){
                     int index = lessons.indexOf(title2);
                     lessons.set(lessons.indexOf(title),title2);
                     lessons.set(index,title);
                     if (lessons.contains(title+"-Exercise")){
                         lessons.remove(title+"-Exercise");
                         lessons.add(lessons.indexOf(title)+1,title+"-Exercise");
                     }
                     if (lessons.contains(title2+"-Exercise")){
                         lessons.remove(title2+"-Exercise");
                         lessons.add(lessons.indexOf(title2)+1,title2+"-Exercise");
                     }
                 }
                 break;
              case "Exercise":
                  if (lessons.contains(title)){
                      if (!lessons.contains(title+"-Exercise")){
                          lessons.add(lessons.indexOf(title)+1,title+"-Exercise");
                      }
                  }else{
                      lessons.add(title);
                      lessons.add(title+"-Exercise");
                  }
                  break;
          }
          line = scanner.nextLine();
      }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println(i+1+"."+lessons.get(i));
        }
    }
}
