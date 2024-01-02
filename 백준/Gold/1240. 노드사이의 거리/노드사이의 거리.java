import java.util.*;
import java.io.*;

public class Main {

    static int map[][];
    static int dis[][];
    public static void main(String[] args) throws IOException {

        //make tree
        /*
         1. 양방향 트리 만들기
         2. BFS 순회로 결과 도출하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        dis = new int[N + 1][N + 1];

        for (int i = 0; i < N -1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int nodeDis = Integer.parseInt(st.nextToken());
            map[nodeA][nodeB] = map[nodeB][nodeA] = 1;
            dis[nodeA][nodeB] = dis[nodeB][nodeA] = nodeDis;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bfs(start,end,N);
        }
    }

    private static void bfs(int start, int end, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        boolean visited[] = new boolean[node+1];
        visited[start] = true;

        int ans[] = new int[node + 1];

        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 1; i <= node; i++) {
                if(map[now][i] == 1 && !visited[i]){
                    ans[i] += dis[now][i] + ans[now];
                    if(i == end){
                        System.out.println(ans[end]);
                        return;
                    }
                    q.add(i);
                    visited[i] = true;
                }

            }

        }


    }
}
