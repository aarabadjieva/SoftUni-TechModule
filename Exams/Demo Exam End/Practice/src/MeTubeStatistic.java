import java.util.*;

public class MeTubeStatistic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        Map<String, Video> videos = new LinkedHashMap<>();
        while (!input.equals("stats time")){
            if (input.contains("-")){
                String[] nameAndViews = input.split("-");
                String name = nameAndViews[0];
                int views = Integer.parseInt(nameAndViews[1]);
                if (!videos.containsKey(name)){
                    Video video = new Video(name,views);
                    videos.put(name,video);
                }else{
                    videos.get(name).setViews(videos.get(name).getViews()+views);
                }
            }else if (input.contains(":")){
                String[] likeAndName = input.split(":");
                String likeOrDislike = likeAndName[0];
                String name = likeAndName[1];
                if (videos.containsKey(name)){
                    if (likeOrDislike.equals("like")){
                        videos.get(name).setLikes(videos.get(name).getLikes()+1);
                    }else{
                        videos.get(name).setLikes(videos.get(name).getLikes()-1);
                    }
                }
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        if(command.equals("by likes")){
            videos.values().stream().sorted((e1,e2)->{
                int result = Integer.compare(e2.getLikes(), e1.getLikes());
            return result;
            })
            .forEach(e-> System.out.printf("%s - %d views - %d likes%n",e.getName(),e.getViews(),e.getLikes()));
        }else{
            videos.values().stream().sorted((e1,e2)->{
                int result = Integer.compare(e2.getViews(), e1.getViews());
                return result;
            }).forEach(e-> System.out.printf("%s - %d views - %d likes%n",e.getName(),e.getViews(),e.getLikes()));
        }
    }
}
class Video{
    private String name;
    private int views;
    private int likes;

    public Video(String name, int views) {
        this.name = name;
        this.views = views;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
