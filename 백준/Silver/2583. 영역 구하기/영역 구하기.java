import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static boolean vistied[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        vistied = new boolean[M][N];

        for (int i = 0; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int sx  = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int x = sy ; x < ey ; x++) {
                for (int y = sx ; y < ex ; y++) {
                    map[x][y] =1;
                }

            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        int land = 0;
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 1 && !vistied[i][j]){
                    result.add(bfs(i,j));
                    land ++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(land);
        for(int temp : result){
            System.out.print(temp + " ");
        }
    }

    private static int bfs(int si,int sj){
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(si,sj));
        vistied[si][sj] = true;
        cnt ++;

        while(!q.isEmpty()){
            Point now = q.poll();
            for (int d = 0; d < dx.length ; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 0 &&!vistied[nx][ny]){
                    cnt++;
                    vistied[nx][ny] = true;
                    q.add(new Point(nx, ny));

                }
            }
        }
        return cnt;
    }

    private static void print(){
        for (int i = 0; i <map.length; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

}