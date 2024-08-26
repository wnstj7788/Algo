import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {0, 0, -1, 1}; // left, right, up, down
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start2048(map, 0);
        System.out.println(result);
    }

    public static void start2048(int[][] map, int cnt) {
        if (cnt == 5) {
            // Find the maximum value in the map and update the result
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, map[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] newMap = move(map, i);
            start2048(newMap, cnt + 1);
        }
    }

    public static int[][] move(int[][] map, int direction) {
        int[][] newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int idx = (direction == 1 || direction == 3) ? N - 1 : 0;
            int pos = idx;

            for (int j = 0; j < N; j++) {
                int x = (direction == 0 || direction == 1) ? i : j;
                int y = (direction == 0 || direction == 1) ? j : i;

                if (direction == 1 || direction == 3) {
                    y = N - 1 - y;
                    x = N - 1 - x;
                }

                if (map[x][y] != 0) {
                    if (line[pos] == map[x][y]) {
                        line[pos] *= 2;
                        pos += (direction == 1 || direction == 3) ? -1 : 1;
                    } else if (line[pos] == 0) {
                        line[pos] = map[x][y];
                    } else {
                        pos += (direction == 1 || direction == 3) ? -1 : 1;
                        line[pos] = map[x][y];
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                int x = (direction == 0 || direction == 1) ? i : j;
                int y = (direction == 0 || direction == 1) ? j : i;

                if (direction == 1 || direction == 3) {
                    y = N - 1 - y;
                    x = N - 1 - x;
                }

                newMap[x][y] = line[j];
            }
        }

        return newMap;
    }
}