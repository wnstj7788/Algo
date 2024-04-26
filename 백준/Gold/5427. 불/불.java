import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

static int dx[] = {-1,0,1,0};
static int dy[]= {0,-1,0,1};
static char map[][];
static boolean visited[][];
static int N, M;
static Queue<Node> personQ;
static Queue<Node> fireQ;
static StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int TC = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < TC; tc++) {
        // q초기화
        personQ = new LinkedList<>();
        fireQ = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char[] lineChar = line.toCharArray();
            for (int j = 0; j < N; j++) {
                // 상근이라면 
                if(lineChar[j] == '@'){
                    personQ.add(new Node(i,j));
                }else if(lineChar[j] == '*'){
                    fireQ.add(new Node(i,j));
                }
                map[i][j] = lineChar[j];
            }
        }

        bfs();

   }
   System.out.println(sb.toString());
    
}

public static void bfs(){
    int time = 0;
    boolean flag = false;
    
    while(!personQ.isEmpty()){
        
        int personSize = personQ.size();
        int fireQSize = fireQ.size();

        for (int i = 0; i < fireQSize; i++) {
            Node nowFire = fireQ.poll();

            for (int j = 0; j < dx.length; j++) {
                int nx = nowFire.x + dx[j];
                int ny = nowFire.y + dy[j];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == '.'){
                    map[nx][ny] = '*';
                    fireQ.add(new Node(nx, ny));
                }
            }

        }
        // 불이 먼저 퍼지고 

        // 사람이 퍼져야지 

        for (int i = 0; i < personSize; i++) {
            Node nowPerson = personQ.poll();

            if(nowPerson.x == 0 || nowPerson.x ==M -1 || nowPerson.y == 0 ||nowPerson.y == N-1){
                flag = true;
                time++;
                sb.append(time + "\n");
                return;
            }
        

            for (int j = 0; j < dx.length; j++) {
                int nx = nowPerson.x + dx[j];
                int ny = nowPerson.y + dy[j];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == '.' && !visited[nx][ny]){
                    map[nowPerson.x][nowPerson.y] = '.';
                    map[nx][ny] = '@';
                    personQ.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }


        }

        time++;
    }
    if(!flag){
        sb.append("IMPOSSIBLE" + "\n");
        
    }

}


static class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
}