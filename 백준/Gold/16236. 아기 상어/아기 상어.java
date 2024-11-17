import java.io.*;
import java.util.*;

public class Main {

    static final int BabyShark = 9;
    static int N;
    static int time;
    static int map[][];
    static int nowSize = 2;
    static int eatFish;

    public static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int nowTime;
        public Shark(int x, int y, int nowTime) {
            this.x = x;
            this.y = y;
            this.nowTime = nowTime;
        }
        @Override
        public int compareTo(Shark o) {
            if (this.nowTime != o.nowTime)
                return this.nowTime - o.nowTime;
            if (this.x != o.x)
                return this.x - o.x;
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == BabyShark) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                } else {
                    map[i][j] = num;
                }
            }
        }

        while (true) {
            int dist[][] = new int[N][N];
            for (int[] row : dist) Arrays.fill(row, -1);

            PriorityQueue<Shark> pq = new PriorityQueue<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY});
            dist[startX][startY] = 0;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];

                int[] dx = {-1, 0, 1, 0};
                int[] dy = {0, -1, 0, 1};

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (dist[nx][ny] == -1 && map[nx][ny] <= nowSize) {
                            dist[nx][ny] = dist[x][y] + 1;
                            if (map[nx][ny] != 0 && map[nx][ny] < nowSize) {
                                pq.add(new Shark(nx, ny, dist[nx][ny]));
                            }
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            if (pq.isEmpty()) {
                System.out.println(time);
                break;
            }

            Shark fish = pq.poll();
            time += fish.nowTime;
            eatFish++;
            map[fish.x][fish.y] = 0;
            if (eatFish == nowSize) {
                nowSize++;
                eatFish = 0;
            }
            startX = fish.x;
            startY = fish.y;
        }
    }
}