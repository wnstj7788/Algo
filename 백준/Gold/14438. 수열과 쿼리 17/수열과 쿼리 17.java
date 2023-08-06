import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static  int[] arr;
    static int tree[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
         arr = new int[N + 1];
         tree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, N ,1);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                updateTree(1,N,1,b,c);
            }else{
                sb.append(query(1,N,1,b,c) + "\n");
            }

        }

        System.out.println(sb.toString());
    }

    public static int init(int start , int end, int node ){
        if(start == end){
            return tree[node] = arr[start];
        }

        int mid = (start + end) /2;
    // 둘중에 작은걸로 선정
        return tree[node] = Math.min(init(start, mid, node * 2),init(mid +1 , end, node * 2 +1 ));
    }

    public static int updateTree(int start, int end, int node, int index, int val){
        if(index < start || index > end){
            return tree[node]; // 범위 벗어나면 현재 노드를 반환
        }

        if(start == end){
            return tree[node] = val; // 목표 노드에 도착하면 해당 값으로 업데이트
        }
        int mid = (start + end) /2 ; // 값을 찾으러 감

        return tree[node] =  Math.min(updateTree(start, mid, node * 2, index, val),
                updateTree(mid + 1, end, node * 2 + 1, index, val));
    }

    public static int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node]; // 목표 노드 반환
        }

        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
    }

}