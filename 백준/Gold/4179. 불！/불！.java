import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class Main {
        static int dx[] = {-1,0,1,0};
        static int dy[] = {0,-1,0,1};
        static int N, M , result;
        static char[][] map;
        static Queue<Node> jihoonQ = new LinkedList<>();
        static Queue<Node> fireQ = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                char[] tempChar = temp.toCharArray();
                for (int j = 0; j < M; j++) {
                    char command = tempChar[j];
                    map[i][j] = command;
                    if(command == 'J'){
                        jihoonQ.add(new Node(i,j));
                    }
                    if(command  == 'F'){
                        fireQ.add(new Node(i,j));
                    }
                }

            } // input end

            bfs();

           
        
        }


        public static void bfs() {
            while (!jihoonQ.isEmpty()) {
                int size = fireQ.size();
                for (int i = 0; i < size; i++) {
                    Node nowFire = fireQ.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = nowFire.x + dx[j];
                        int ny = nowFire.y + dy[j];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                            map[nx][ny] = 'F';
                            fireQ.add(new Node(nx, ny));
                        }
                    }
                }
        
                size = jihoonQ.size();
                for (int i = 0; i < size; i++) {
                    Node nowJihoon = jihoonQ.poll();
                    if (nowJihoon.x == 0 || nowJihoon.x == N - 1 || nowJihoon.y == 0 || nowJihoon.y == M - 1) {
                        System.out.println(result + 1);
                        return;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nx = nowJihoon.x + dx[j];
                        int ny = nowJihoon.y + dy[j];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '.') {
                            map[nx][ny] = 'J';
                            jihoonQ.add(new Node(nx, ny));
                        }
                    }
                }
                result++;
            }
            System.out.println("IMPOSSIBLE");
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