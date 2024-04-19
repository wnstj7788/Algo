import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
     * 1은 이동할 수 있음 
     * 0은 이동할 수 없음
     * n,M까지 가는데 최소 
     */

     static int dx[]= {1,0,-1,0};
     static int dy[] = {0,1,0,-1};
     static boolean visited[][];
     static int map[][];
     static int n,m, result;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j];
            }
        }

        bfs();
        System.out.println(result);

        
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new Node(0,0,1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == n-1 && now.y == m-1){
             
                result = now.cnt;
                break;
            }

            for(int d = 0 ; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == '1'){
                    visited[nx][ny] = true;
                  
                    q.add(new Node(nx, ny, now.cnt + 1));
                }

            }
        }
        
        
    }

    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
}