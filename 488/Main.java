import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                scanner.nextLine();
                int a = Integer.parseInt(scanner.nextLine());
                int f = Integer.parseInt(scanner.nextLine());

                String singleWave = createSingleWave(a);
                for (int j = 0; j < f; j++) {
                    System.out.print(singleWave);
                    if (i == n - 1 && j == f - 1) {
                        break;
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String createSingleWave(int a) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(i);
            }
            sb.append("\n");
        }

        for (int i = a - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                sb.append(i);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}