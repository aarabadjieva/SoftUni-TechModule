package carSalesman;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine = new Engine(input[0],Integer.parseInt(input[1]));
            if (input.length==4){
                engine.setDisplacement(input[2]);
                engine.setEfficiency(input[3]);
            }else if (input.length==3){
                try{
                    Integer.parseInt(input[2]);
                    engine.setDisplacement(input[2]);
                }catch (Exception e){
                    engine.setEfficiency(input[2]);
                }
            }
            engines.put(input[0],engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine = engines.get(input[1]);
            Car car = new Car(input[0],engine);
            if (input.length==4){
                car.setWeight(input[2]);
                car.setColor(input[3]);
            }else if (input.length==3){
                try{
                    Integer.parseInt(input[2]);
                    car.setWeight(input[2]);
                }
                catch (Exception e){
                    car.setColor(input[2]);
                }
            }
            cars.add(car);
        }
        cars.stream().forEach(car -> System.out.println(car.toString()));
    }
}
