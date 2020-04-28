import java.util.*;

public class CompanyUSers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companyNames = new TreeMap<>();
        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] companyEmployee = line.split(" -> ");
            String company = companyEmployee[0];
            String id = companyEmployee[1];
            companyNames.putIfAbsent(company, new ArrayList<>());
            if (!companyNames.get(company).contains(id)){
                companyNames.get(company).add(id);
            }
            line = scanner.nextLine();
        }
        companyNames.entrySet().stream().forEach(e->{
            System.out.println(e.getKey());
            for (String employee:e.getValue()
                 ) {
                System.out.println("-- "+employee);
            }
        });
    }
}
