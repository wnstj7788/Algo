import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Point> chickenHouse = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();
    static int N, M;
    static boolean[] selected;
    static int result[];
    static int min = Integer.MAX_VALUE;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    chickenHouse.add(new Point(i, j));
                }
                if (temp == 1) {
                    house.add(new Point(i, j));
                }
                map[i][j] = temp;
            }
        }

        selected = new boolean[chickenHouse.size()];
        result = new int[M];
        combination(0, 0);
        System.out.println(min);
    }

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            min = Math.min(min, calculateDistance());
            return;
        }

        for (int i = start; i < chickenHouse.size(); i++) {
            selected[i] = true;
            combination(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

    private static int calculateDistance() {
        int total = 0;

        for (Point h : house) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chickenHouse.size(); i++) {
                if (selected[i]) {
                    int dist = Math.abs(h.x - chickenHouse.get(i).x) + Math.abs(h.y - chickenHouse.get(i).y);
                    minDist = Math.min(minDist, dist);
                }
            }
            total += minDist;
        }

        return total;
    }
}