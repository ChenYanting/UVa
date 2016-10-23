import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();

                int start = Math.min(i, j);
                int end = Math.max(i, j);
                int result = 0;
                for (int k = start; k <= end; k++) {
                    int length = calculateCycleLength(k);
                    if (length > result) {
                        result = length;
                    }
                }

                System.out.printf("%d %d %d\n", i, j, result);
            }
        } catch (Exception e) {
        }
    }

    private static int calculateCycleLength(int num) {
        int length = 1;

        while (num != 1) {
            num = (num % 2 == 0) ? num / 2 : 3 * num + 1;
            length++;
        }

        return length;
    }
}