import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                int current = scanner.nextInt();
                int destination = scanner.nextInt();

                if (current == -1 && destination == -1) {
                    break;
                } else {
                    int diff = Math.abs(current - destination);
                    System.out.println(Math.min(diff, 100 - diff));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}