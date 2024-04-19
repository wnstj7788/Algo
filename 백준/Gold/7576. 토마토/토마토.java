import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, days;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }

        bfs();

        if (checkAllTomatoes()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            days++;
        }
        days--; // 마지막에 큐가 비워질 때 days가 하나 더 증가되므로 하나 감소시킵니다.
    }

    public static boolean checkAllTomatoes() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}