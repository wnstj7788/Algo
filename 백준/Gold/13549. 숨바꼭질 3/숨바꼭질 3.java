import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            return Integer.compare(this.y, other.y);
        }
    }

    /*
    수빈이 걷거나 순간이동
    걷는다 -> 1초 후  x -1 or x + 1로 이동
    순간이동 -> 0 초 후 2*x
    빠르게 찾는 경우
     */
    static int result;
    static int[] work = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bfs(N, M);
        System.out.println(result);

    }

    static void bfs(int N, int M) {
        PriorityQueue<Point> q =new PriorityQueue<>();
        q.add(new Point(N, 0));

        boolean[] visited = new boolean[100001];
        int nowZone = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Point now  = q.poll();
            nowZone = now.x;
            cnt = now.y;

            if(nowZone == M){
                result = cnt;
                break;
            }

            visited[nowZone] = true;


            if (0 <= nowZone * 2 && nowZone * 2 < 100001 && !visited[nowZone * 2] ) {
                q.add(new Point(nowZone *2, cnt));
            }

            if ( 0 <= nowZone && nowZone < 100001 && nowZone< M && !visited[nowZone + 1]) {
                q.add(new Point(nowZone+ 1, cnt + 1));
            }

            if (0 <= nowZone - 1 && nowZone - 1 < 100001 && !visited[nowZone - 1]) {
                q.add(new Point(nowZone- 1, cnt + 1));
            }


        }




    }
}