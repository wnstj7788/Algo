import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int x = 0;

            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    bitmask |= (1 << (x - 1));
                    break;
                case "remove":
                    bitmask &= ~(1 << (x - 1));
                    break;
                case "check":
                    if ((bitmask & (1 << (x - 1))) != 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    bitmask ^= (1 << (x - 1));
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}