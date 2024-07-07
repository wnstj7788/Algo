import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int map[][];
    static final int DRAW = 1;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static boolean visited[][];

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];  
        int K = Integer.parseInt(st.nextToken());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            initArray(x1, y1, x2, y2);
        }

        ArrayList<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != DRAW && !visited[i][j]) {
                    sizes.add(bfs(i, j));
                }
            }
        }
        Collections.sort(sizes);  

        sb.append(sizes.size()).append("\n");
        for (int size : sizes) {
            sb.append(size).append(" ");
        }
        System.out.println(sb.toString().trim());  
    }

    public static void initArray(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = DRAW;
            }
        }
    }

    public static int bfs(int i, int j) {
        int size = 0;
        Queue<Node> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Node(i, j));
        size++;  

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (isPossible(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    size++;
                }
            }
        }
        return size;
    }

    public static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != DRAW;
    }
}