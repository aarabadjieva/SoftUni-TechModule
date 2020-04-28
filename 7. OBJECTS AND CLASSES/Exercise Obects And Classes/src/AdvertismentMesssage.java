import java.util.*;

public class AdvertismentMesssage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
         "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));
        Random rnd = new Random();

        for (int i = 0; i < count; i++) {
            int phraseIndex = rnd.nextInt(phrases.size());
            int eventIndex = rnd.nextInt(events.size());
            int authorIndex = rnd.nextInt(authors.size());
            int cityIndex = rnd.nextInt(cities.size());
            System.out.println(phrases.get(phraseIndex)+" "+events.get(eventIndex)+" "+
                    authors.get(authorIndex)+" - "+cities.get(cityIndex));
        }
    }
}
