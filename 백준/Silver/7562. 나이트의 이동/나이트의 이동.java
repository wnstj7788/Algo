import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_7562
 */
public class Main {
    static int dx[] = {1,1,-1,-1,2,2,-2,-2};
    static int dy[] = {2,-2,2,-2,1,-1,1,-1};
    static int map[][];
    static boolean visited[][];
    static int N, cnt, targetX, targetY;
    static Queue<Node> q;
    static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            q = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.add(new Node(x,y));
            
            map[x][y] = 1;
            visited[x][y] = true;

            st = new StringTokenizer(br.readLine());

            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            bfs();
            
        }

        System.out.println(sb.toString());
         
    }

    public static void bfs(){
        int result  = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Node now = q.poll();
                if(now.x == targetX && now.y == targetY){
                    sb.append(result + "\n");
                    return;
                }
                    

                for (int i = 0; i < 8; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Node(nx,ny));
                    }
                }
            }
            result++;
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