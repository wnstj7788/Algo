import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int dx[] = {1,-1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean visited[] = new  boolean[100001];

        q.add(new Node(N,0));
        visited[N] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == K){
                System.out.println(now.cnt);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = 0;
                if(i == 2){
                     nx = now.x * 2;
                }else{
                     nx = now.x + dx[i];
                }

                if(nx >= 0 && nx <= 100000 && !visited[nx]){
                    q.add(new Node(nx, now.cnt+1));
                    visited[nx] = true;
                }
            }

        }
        
    }


    public static class Node{
        int x;
        int cnt;

        public Node(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    
}