import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static LinkedList<Integer> list;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) { // 10개의 테스트 케이스
            list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int commandLen = Integer.parseInt(br.readLine());
            commandCenter(commandLen);

            sb.append("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void commandCenter(int len) throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String command = st.nextToken();
            switch (command) {
                case "I":
                    commandI();
                    break;
                case "D":
                    commandD();
                    break;
                case "A":
                    commandA();
                    break;
            }
        }
    }

    public static void commandI() {
        int index = Integer.parseInt(st.nextToken());
        int appendSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < appendSize; i++) {
            list.add(index + i, Integer.parseInt(st.nextToken()));
        }
    }

    public static void commandD() {
        int index = Integer.parseInt(st.nextToken());
        int delSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < delSize; i++) {
            list.remove(index);
        }
    }

    public static void commandA() {
        int appendSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < appendSize; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }
}