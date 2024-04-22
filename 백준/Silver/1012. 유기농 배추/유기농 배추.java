import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {0,-1,0,1};
    static int dy[] = {-1,0,1,0};
    static int result = 0;
    static int map[][];
    static int N, M ;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        

        for (int tc = 0; tc < TC; tc++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int k = 0; k < size; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1){
                        bfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);

            
        }
        
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        visited[x][y] = true;

        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                }
            }
        }
    }


    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    
    
}