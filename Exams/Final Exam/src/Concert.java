import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Band> bands = new LinkedHashMap<>();
        int totalTime = 0;
        while (!line.equals("start of concert")){
            String[] input = line.split(";\\s");
            String bandName = input[1];
            if (input[0].equals("Add")){
                String[] members = input[2].split(",\\s");
                if (!bands.containsKey(bandName)){
                    bands.put(bandName, new Band(bandName, new ArrayList<>(),0));
                }
                for (String member:members
                ) {
                    if (!bands.get(bandName).getMembers().contains(member)){
                        bands.get(bandName).getMembers().add(member);
                    }
                }
            }else {
                int time = Integer.parseInt(input[2]);
                totalTime+=time;
                if (!bands.containsKey(bandName)){
                    bands.put(bandName, new Band(bandName, new ArrayList<>(), 0));
                }
                if (bands.get(bandName).getTime()==0){
                    bands.get(bandName).setTime(time);
                }else{
                    bands.get(bandName).setTime(bands.get(bandName).getTime()+time);
                }
            }
            line = scanner.nextLine();
        }
        System.out.println("Total time: " + totalTime);
        bands.values().stream().sorted(Comparator.comparingInt(Band::getTime).reversed().thenComparing(Band::getName))
                .forEach(e-> System.out.printf("%s -> %d%n",e.getName(),e.getTime()));
        String bandName = scanner.nextLine();
        if (bands.containsKey(bandName)){
            System.out.println(bandName);
            bands.get(bandName).getMembers().stream().forEach(e-> System.out.printf("=> %s%n",e));
        }
    }
}
class Band{
    private String name;
    private List<String> members;
    private int time;

    public Band(String name, List<String> members, int time) {
        this.name = name;
        this.members = members;
        this.time = time;
    }

    public Band(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}