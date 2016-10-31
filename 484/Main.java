import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Map<Integer, Integer> results = new LinkedHashMap<>();
            while (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (results.containsKey(input)) {
                    results.put(input, results.get(input) + 1);
                } else {
                    results.put(input, 1);
                }
            }

            Iterator<Integer> iterator = results.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                System.out.printf("%d %d\n", key, results.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}