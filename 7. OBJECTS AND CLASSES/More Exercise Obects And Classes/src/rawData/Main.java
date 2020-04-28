package rawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> cars = new LinkedHashMap<>();
        cars.put("fragile",new ArrayList<>());
        cars.put("flamable",new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine = new Engine(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]),input[4]);
            Tyres tyres = new Tyres(Double.parseDouble(input[5]),Integer.parseInt(input[6]),Double.parseDouble(input[7]),
                    Integer.parseInt(input[8]),Double.parseDouble(input[9]),Integer.parseInt(input[10]),
                    Double.parseDouble(input[11]),Integer.parseInt(input[12]));
            Car car = new Car(input[0],engine,cargo,tyres);
            if (car.getCargo().getType().equals("fragile")){
                cars.get("fragile").add(car);
            }else{
                cars.get("flamable").add(car);
            }
        }
        String type = scanner.nextLine();
        if (type.equals("fragile")){
            cars.get("fragile").stream().filter(car -> car.getTyres().getTire1Pressure()<1||car.getTyres().getTire2Pressure()<1||
                    car.getTyres().getTire3Pressure()<1||car.getTyres().getTire4Pressure()<1).forEach(car -> System.out.println(car.getModel()));
        }else{
            cars.get("flamable").stream().filter(car -> car.getEngine().getPower()>250).forEach(car -> System.out.println(car.getModel()));
        }
    }
}
