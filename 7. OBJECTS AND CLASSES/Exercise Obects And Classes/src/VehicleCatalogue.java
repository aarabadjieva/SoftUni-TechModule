import java.util.*;

public class VehicleCatalogue {
    public static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsePower;


        public Vehicle(String type, String model, String color, int horsePower) {
            this.setType(type);
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        private void setType(String type) {
            type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public String getModel(){
            return this.model;
        }
        public String toString(){
            return String.format("Type: %s%n"+
                    "Model: %s%n"+
                    "Color: %s%n"+
                    "Horsepower: %d",this.getType(),this.getModel(),this.color,this.horsePower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();
        String line = scanner.nextLine();
        double carsAverage = 0;
        double trucksAverage = 0;
        while (!line.equals("End")) {
            String[] input = line.split(" ");
            Vehicle vehicle = new Vehicle(input[0], input[1], input[2], Integer.parseInt(input[3]));
            if (vehicle.getType().equals("Car")) {
                cars.add(vehicle);
            } else {
                trucks.add(vehicle);
            }
            line = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle car : cars
            ) {
                if (car.getModel().equals(model)){
                    System.out.println(car.toString());
                }
            }
            for (Vehicle truck : trucks
            ) {
                if (truck.getModel().equals(model)){
                    System.out.println(truck.toString());
                }
            }
            model = scanner.nextLine();
        }
        if (!cars.isEmpty()){
            for (Vehicle car : cars) {
                carsAverage+=car.horsePower;
            }
            carsAverage = carsAverage/cars.size();
        }
        if (!trucks.isEmpty()){
            for (Vehicle truck : trucks) {
                trucksAverage+=truck.horsePower;
            }
            trucksAverage = trucksAverage/trucks.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverage);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverage);
    }
}
