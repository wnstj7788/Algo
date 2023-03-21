import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = 1;
            for (int i = 0; i < b; i++) {
                result = (result * a) % 10;
            }
            if (result == 0) {
                result = 10;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}