import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static long  M ,K;
    static long arr[], tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //makeTree
        makeTree(1, N, 1);
       // System.out.println("Tree = " + Arrays.toString(tree));

        for (int i = 0; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int target = Integer.parseInt(st.nextToken());
                int changeNum = Integer.parseInt(st.nextToken());
                updateTree(1, N ,1,target,changeNum);
                //System.out.println("Tree = " + Arrays.toString(tree));

            }else{
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(mulTree(1, N ,1, left, right) + "\n");
            }
        }
        System.out.println(sb.toString());

    }

    // 처음 곱을 저장해둘 makeTree를 생성하기
    private static long makeTree(int start, int end, int node){

        if(start == end){ // 시작과 끝이 같으면 리프 노드임으로 마지막 리프 단 채워주기
            return tree[node] = arr[start];
        }

        int mid = (start + end) /2 ;

        return  tree[node] = makeTree(start, mid , node * 2) * makeTree(mid +1 , end, node * 2 +1) % 1000000007;
    }

    private static long updateTree(int start, int end,int node, int target, int changeNum){
        // 범위를 초과하면 현재 값 리턴
        if(target < start || target > end){
            return tree[node];
        }

        if(start == end){
            return tree[node] = changeNum; // 값을 갱신해줌 내가 원하는 곳에 왔다는 의미
        }

        int mid  = (start + end) /2;

        // 업데이트
        return tree[node] = updateTree(start, mid, node * 2, target, changeNum) * updateTree(mid +1 , end , node *2 +1 , target,changeNum)  % 1000000007;
    }

    private static long mulTree(int start, int end, int node, int left, int right){
        if(end < left || right < start){
            return 1;
        }
        if(left <= start && end <= right){
            return tree[node];
        }

        int mid =  (start + end) / 2;

        return mulTree(start, mid, node*2, left, right) * mulTree(mid +1, end, node *2 + 1,left,right) % 1000000007;
    }



}