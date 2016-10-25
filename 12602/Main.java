import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.valueOf(scanner.nextLine());
            for (int i = 0; i < number; i++) {
                String[] input = scanner.nextLine().split("-");
                if (Math.abs(convert(input[0]) - Integer.valueOf(input[1])) <= 100) {
                    System.out.println("nice");
                } else {
                    System.out.println("not nice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int convert(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            result += (c - 'A') * Math.pow(26, str.length() - 1 - i);
        }

        return result;
    }
}