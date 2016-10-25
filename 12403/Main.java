import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int numberOfOperations = Integer.valueOf(scanner.nextLine());

            int sum = 0;
            for (int i = 0; i < numberOfOperations; i++) {
                String[] operation = scanner.nextLine().split(" ");

                if ("report".equalsIgnoreCase(operation[0])) {
                    System.out.println(sum);
                } else {
                    sum += Integer.valueOf(operation[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}