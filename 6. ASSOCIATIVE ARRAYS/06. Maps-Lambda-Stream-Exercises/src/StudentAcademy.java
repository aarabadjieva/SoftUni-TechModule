import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            studentGrades.putIfAbsent(name,new ArrayList<>());
            studentGrades.get(name).add(grade);
        }
        Map<String,Double> averageStudents = new LinkedHashMap<>();
        for (String name : studentGrades.keySet()) {
            double sum = 0;
            for (int i = 0; i < studentGrades.get(name).size(); i++) {
                sum+=studentGrades.get(name).get(i);
            }
            double average = sum/studentGrades.get(name).size();
            if (average>=4.5){
                averageStudents.put(name,average);
            }
        }
        averageStudents.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .forEach(e-> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue()));
    }
}
