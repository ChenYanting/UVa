import java.lang.StringBuilder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNext()) {
                String[] words = scanner.nextLine().split(" ");

                for (int i = 0; i < words.length; i++) {
                    StringBuilder sb = new StringBuilder(words[i]);
                    System.out.print(sb.reverse().toString());
                    if (i == words.length - 1) {
                        break;
                    }
                    System.out.print(" ");
                }

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}