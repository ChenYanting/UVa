import java.lang.Exception;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
                int c = System.in.read();
                if (c == -1) {
                    break;
                } else if (c == '\n') {
                    System.out.write('\n');
                } else {
                    System.out.write((char) (c - 7));
                }
            }
        } catch (Exception e) {
        }
    }
}