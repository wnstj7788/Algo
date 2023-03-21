import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dice[] = new int[7];
    static int map[][];
    static int M, N, X, Y;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        } // end input

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            move(Integer.parseInt(st.nextToken()));
        }

    }

    private static void move(int d) {
        int nx = X + dx[d - 1];
        int ny = Y + dy[d - 1];
        if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
            return;
        rotate(nx,ny,d);
        X = nx; Y = ny;
    }

    private static void rotate(int x, int y, int d) {
        int temp = dice[1];
        switch(d) {
        case 1:
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = temp;
            break;
        case 2:
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
            break;
        case 3:
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
            break;
        case 4:
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
            break;
        }
        if(map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        System.out.println(dice[1]);
    }
}