import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0,-1,0,1};
    static int dy[] = {-1,0,1,0};
    static int map[][];
    static int N, M;
    static Queue<Virus> q = new LinkedList<>();
    static int result = Integer.MIN_VALUE;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    q.add(new Virus(i, j));
                }
                map[i][j] = temp;
            }
        }// input end

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int depth, int count) {
        if (depth == 3) {
            int[][] tempMap = deepCopy(map);
            bfs(tempMap);
            return;
        }

        for (int i = count; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            if (map[x][y] == 0) {
                map[x][y] = 1; // 벽세우기
                dfs(depth + 1, i + 1);
                map[x][y] = 0; // 벽 다시 빼기
            }
        }
    }

    public static void bfs(int[][] tempMap) {
        Queue<Virus> queue = new LinkedList<>(q);
        boolean[][] visited = new boolean[N][M];

        while (!queue.isEmpty()) {
            Virus current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && tempMap[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    tempMap[nx][ny] = 2;
                    queue.add(new Virus(nx, ny));
                }
            }
        }

        result = Math.max(result, countSafeZone(tempMap));
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    public static int countSafeZone(int[][] tempMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}