import java.util.*;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Song>> playList = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
                String[] input = line.split("_");
                Song current = new Song(input[0], input[1], input[2]);
                if (!playList.containsKey(input[0])) {
                    playList.put(input[0],new ArrayList<>());
                }
                playList.get(input[0]).add(current);
        }
        String print = scanner.nextLine();
        if (playList.containsKey(print)){
            playList.get(print).forEach(e-> System.out.println(e.name));
        }else{
           playList.entrySet().stream().forEach(e->{
               for (Song song:e.getValue()
                    ) {
                   System.out.println(song.name);
               }
           });
        }
    }
    public static class Song{
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }
}
