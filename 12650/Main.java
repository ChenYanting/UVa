import java.lang.Exception;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                int[] people = new int[scanner.nextInt()];
                int backNumber = scanner.nextInt();
                for (int i = 0; i < backNumber; i++) {
                    people[scanner.nextInt() - 1] = 1;
                }

                for (int i = 0; i < people.length; i++) {
                    if (people[i] == 0) {
                        System.out.printf("%d ", i + 1);
                    }
                }

                if (people.length == backNumber) {
                    System.out.print("*");
                }

                System.out.println();
            }
        } catch (Exception e) {
        }
    }
}