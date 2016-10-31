import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int maxLine = 0;
            List<String> inputs = new ArrayList<>();
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (input.length() > maxLine) {
                    maxLine = input.length();
                }
                inputs.add(input);
            }

            for (int i = 1; i <= maxLine; i++) {
                for (int j = inputs.size() - 1; j >= 0; j--) {
                    String input = inputs.get(j);
                    if (input.length() < i) {
                        System.out.print(" ");
                    } else {
                        System.out.print(input.charAt(i - 1));
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}