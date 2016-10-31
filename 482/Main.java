import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = Integer.valueOf(scanner.nextLine());
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                String[] results = getResults(scanner.nextLine().split(" "), scanner.nextLine().split(" "));
                printResults(results);
                if (i != n - 1) {
                    System.out.println();
                    scanner.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] getResults(String[] positions, String[] values) {
        String[] results = new String[positions.length];

        for (int i = 0; i < positions.length; i++) {
            results[Integer.valueOf(positions[i]) - 1] = values[i];
        }

        return results;
    }

    private static void printResults(String[] results) {
        for (String result : results) {
            System.out.println(result);
        }
    }
}