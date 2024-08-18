import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 북, 동, 남, 서 방향 정의
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    static int cleanedCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 로봇 청소기 시작
        startCleaningRoom(r, c, d);
        System.out.println(cleanedCount);
    }

    private static void startCleaningRoom(int x, int y, int d) {
        while (true) {
            // 1. 현재 칸을 청소
            if (map[x][y] == 0) {
                map[x][y] = 2;  // 청소된 칸은 2로 표시
                cleanedCount++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;  // 반시계 방향으로 회전
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (map[nx][ny] == 0) {  // 청소되지 않은 칸이 있다면
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }

            if (!found) {  // 4방향 모두 청소가 되어있거나 벽일 때
                int backDir = (d + 2) % 4;  // 뒤쪽 방향
                int bx = x + dx[backDir];
                int by = y + dy[backDir];

                if (map[bx][by] == 1) {  // 뒤가 벽이라 후진 불가
                    break;
                }

                // 후진 가능
                x = bx;
                y = by;
            }
        }
    }
}