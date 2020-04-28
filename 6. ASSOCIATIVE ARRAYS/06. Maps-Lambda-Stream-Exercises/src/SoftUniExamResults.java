import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, List<String>> allLanguages = new LinkedHashMap<>();
        Map<String, List<Integer>> allPoints = new TreeMap<>();
        while (!line.equals("exam finished")){
            if (line.contains("banned")){
                String[] banned = line.split("-");
                String student = banned[0];
                allPoints.remove(student);
            }else {
                String[] students = line.split("-");
                String student = students[0];
                String language = students[1];
                int points = Integer.parseInt(students[2]);
                allLanguages.putIfAbsent(language,new ArrayList<>());
                allLanguages.get(language).add(student);
                allPoints.putIfAbsent(student,new ArrayList<>());
                allPoints.get(student).add(points);
            }
            line = scanner.nextLine();
        }
        Map<String, Integer> maxPoints = new LinkedHashMap<>();
        for (Map.Entry<String,List<Integer>>entry:allPoints.entrySet()
             ) {
           Collections.sort(entry.getValue());
           int max = entry.getValue().get(entry.getValue().size()-1);
           maxPoints.put(entry.getKey(),max);
        }
        System.out.println("Results:");
        maxPoints.entrySet().stream().sorted((e1,e2)->{
            int compare = Integer.compare(e2.getValue(),e1.getValue());
            if (compare==0){
                compare = e1.getKey().compareTo(e2.getKey());
                return compare;
            }
            return compare;
        }).forEach(e-> System.out.printf("%s | %d%n",e.getKey(),e.getValue()));
        System.out.println("Submissions:");
        allLanguages.entrySet().stream().sorted((e1,e2)->{
            int compare = Integer.compare(e2.getValue().size(),e1.getValue().size());
            if (compare==0){
                compare = e1.getKey().compareTo(e2.getKey());
                return compare;
            }
            return compare;
        }).forEach(e-> System.out.printf("%s - %d%n",e.getKey(),e.getValue().size()));
    }
}
