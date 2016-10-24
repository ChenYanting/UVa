import java.lang.Exception;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                int result = 0;
                String input = scanner.nextLine();
                String[] words = input.split("[^a-zA-Z]");
                for (String word : words) {
                    if (!"".equalsIgnoreCase(word)) {
                        result++;
                    }
                }

                System.out.printf("%d\n", result);
            }
        } catch (Exception e) {
        }
    }
}