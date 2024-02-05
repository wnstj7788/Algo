import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static int max = Integer.MIN_VALUE;
    static int[][] map;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int size = bfs(i, j);
                    pictureCount++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxSize);
    }

    public static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        map[i][j] = 2;
        q.add(new Point(i, j));
        int num = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == 1) {
                    num++;
                    map[nextX][nextY] = 2;
                    q.add(new Point(nextX, nextY));
                }
            }
        }

        return num;
    }
}