import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N, M ;
    static boolean visited[];
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }


        for (int i = 1; i <=N ; i++) {
            if(!visited[i]){
                dfs(i);
                result ++;
            }
        }

        System.out.println(result);



    }

    private static void dfs(int start){
        visited[start] = true;
        for (int i = 1; i <= N ; i++) {
            if(map[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}