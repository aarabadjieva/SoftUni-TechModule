import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles {
    public static class Article{
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> allArticles = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0], input[1],input[2]);
            allArticles.add(article);
        }
        String criteria = scanner.nextLine();
        if (criteria.equals("title")){
            allArticles.stream().sorted(Comparator.comparing(e->e.title)).forEach(e-> System.out.printf("%s - %s: %s%n",e.title,e.content,e.author));
        }else if (criteria.equals("content")){
            allArticles.stream().sorted(Comparator.comparing(e->e.content)).forEach(e-> System.out.printf("%s - %s: %s%n",e.title,e.content,e.author));
        }else{
            allArticles.stream().sorted(Comparator.comparing(e->e.author)).forEach(e-> System.out.printf("%s - %s: %s%n",e.title,e.content,e.author));
        }
    }
}
