import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Long> results = new HashMap<>();

    public static void main(String[] args) {
        results.put(1, new Long(1));
        results.put(2, new Long(2));

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Long> results = new HashMap<>();
        try {
            while (true) {
                int n = scanner.nextInt();

                if (n == 0) {
                    break;
                } else {
                    if (!results.containsKey(n)) {
                        results.put(n, getNumberOfAncestors(n));
                    }
                    System.out.println(results.get(n));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Long getNumberOfAncestors(int n) {
        if (results.containsKey(n)) {
            return results.get(n);
        } else {
            if (!results.containsKey(n - 1)) {
                results.put(n - 1, getNumberOfAncestors(n - 1));
            }
            if (!results.containsKey(n - 2)) {
                results.put(n - 2, getNumberOfAncestors(n - 2));
            }
            return results.get(n - 1) + results.get(n - 2);
        }
    }
}