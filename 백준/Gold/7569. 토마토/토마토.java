import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0,1,0,-1,0,0};
    static int dy[] = {1,0,-1,0,0,0};
    static int dz[] = {0,0,0,0,-1,1};
    static int map[][][];
    static int N, M , H;
    static Queue<Node> q = new LinkedList<>();
    static boolean visited[][][];

    //   1은 토마토, 0은 안익은 토마토, -1은 토마토 없음 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

 

        map = new int[N][M][H];
        visited =  new boolean[N][M][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int j2 = 0; j2 < M; j2++) {
                    int temp = Integer.parseInt(st.nextToken());

                    if(temp == 1){
                        q.add(new Node(j,j2,i));

                    }
                    map[j][j2][i] = temp;
                }
            }
        }
        int result = bfs();
        if(cul()){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
        
    }

    public static int bfs(){
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Node now = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >=0 && nz < H && map[nx][ny][nz] == 0 && !visited[nx][ny][nz]){
                    q.add(new Node(nx, ny, nz));
                    visited[nx][ny][nz] = true;
                    map[nx][ny][nz] = 1;
                }
            }
                
            }

            time++;
            
        }

        return time -1;



    }

    public static boolean cul(){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < M; j2++) {
                    if(map[j][j2][i] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }




    public static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
}