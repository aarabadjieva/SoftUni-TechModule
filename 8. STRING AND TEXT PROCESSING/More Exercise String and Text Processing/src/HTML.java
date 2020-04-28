import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = String.format("<h1>%n%s%n</h1>",scanner.nextLine());
        System.out.println(title);
        String content = String.format("<article>%n%s%n</article>",scanner.nextLine());
        System.out.println(content);
        String comments = scanner.nextLine();
        while (!comments.equals("end of comments")){
            comments = String.format("<div>%n%s%n</div>",comments);
            System.out.println(comments);
            comments = scanner.nextLine();
        }
    }
}
