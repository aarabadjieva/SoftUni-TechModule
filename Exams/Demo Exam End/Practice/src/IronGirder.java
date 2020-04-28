import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IronGirder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, City> cities = new LinkedHashMap<>();
        while (!line.equals("Slide rule")) {
            String[] input = line.split(":|->");
            String city = input[0];
            String timeOrCmd = input[1];
            int passengers = Integer.parseInt(input[2]);
            if (!timeOrCmd.equals("ambush")){
                int time = Integer.parseInt(timeOrCmd);
                if (!cities.containsKey(city)){
                    City currentCity = new City(city, time, passengers);
                    cities.put(city, currentCity);
                }else{
                    if (time<cities.get(city).getBestTime()||cities.get(city).getBestTime()==0){
                        cities.get(city).setBestTime(time);
                    }
                    cities.get(city).setPassengers(cities.get(city).getPassengers()+passengers);
                }
            }else{
                if (cities.containsKey(city)){
                    cities.get(city).setBestTime(0);
                    cities.get(city).setPassengers(cities.get(city).getPassengers()-passengers);
                }
            }
            line = scanner.nextLine();
        }
        cities.values().stream().sorted(Comparator.comparingInt(City::getBestTime)
                .thenComparing(City::getName))
                .forEach(e-> {if(e.getBestTime()!=0&&e.getPassengers()>0) {
        System.out.printf("%s -> Time: %d -> Passengers: %d%n",e.getName(),e.getBestTime(),e.getPassengers());
        }});
    }
}
class City{
    private String name;
    private int bestTime;
    private int passengers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBestTime() {
        return bestTime;
    }

    public void setBestTime(int bestTime) {
        this.bestTime = bestTime;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public City(String name, int bestTime, int passengers) {
        this.name = name;
        this.bestTime = bestTime;
        this.passengers = passengers;
    }
}
