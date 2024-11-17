import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int SIZE = 4;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static class Fish {
        int x, y, d, num;

        public Fish(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }
    }

    public static class Shark {
        int x, y, d, sum;

        public Shark(int x, int y, int d, int sum) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Fish[][] map = new Fish[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = new Fish(i, j, direction, number);
            }
        }


        Fish firstFish = map[0][0];
        Shark shark = new Shark(0, 0, firstFish.d, firstFish.num);
        map[0][0] = null;

        dfs(map, shark);

        System.out.println(maxSum);
    }

    public static void dfs(Fish[][] map, Shark shark) {
        maxSum = Math.max(maxSum, shark.sum);


        Fish[][] newMap = copyMap(map);


        moveFish(newMap, shark.x, shark.y);


        boolean canMove = false;
        for (int step = 1; step <= SIZE; step++) {
            int nx = shark.x + dx[shark.d] * step;
            int ny = shark.y + dy[shark.d] * step;

            if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
            if (newMap[nx][ny] == null) continue;

            canMove = true;
            Fish targetFish = newMap[nx][ny];
            newMap[nx][ny] = null;

            dfs(newMap, new Shark(nx, ny, targetFish.d, shark.sum + targetFish.num));

            newMap[nx][ny] = targetFish;
        }

        if (!canMove) {
            maxSum = Math.max(maxSum, shark.sum);
        }
    }

    public static void moveFish(Fish[][] map, int sharkX, int sharkY) {
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != null) {
                    fishList.add(map[i][j]);
                }
            }
        }

        fishList.sort(Comparator.comparingInt(f -> f.num));

        for (Fish fish : fishList) {
            for (int i = 0; i < 8; i++) {
                int nd = (fish.d + i) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                if (nx == sharkX && ny == sharkY) continue;

                if (map[nx][ny] == null) {
                    map[nx][ny] = fish;
                    map[fish.x][fish.y] = null;
                    fish.x = nx;
                    fish.y = ny;
                    fish.d = nd;
                    break;
                } else {
                    Fish swapFish = map[nx][ny];
                    map[nx][ny] = fish;
                    map[fish.x][fish.y] = swapFish;
                    swapFish.x = fish.x;
                    swapFish.y = fish.y;
                    fish.x = nx;
                    fish.y = ny;
                    fish.d = nd;
                    break;
                }
            }
        }
    }

    public static Fish[][] copyMap(Fish[][] map) {
        Fish[][] newMap = new Fish[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != null) {
                    Fish f = map[i][j];
                    newMap[i][j] = new Fish(f.x, f.y, f.d, f.num);
                }
            }
        }
        return newMap;
    }
}