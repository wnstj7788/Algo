import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     *  0 -> sum   i, j -> 의합
     *  1 -> modify -> i번째를 K로 바꾸는 수식
     *  처음배열은 전부 0으로 세팅
     *
     */
    static int N, M;
    static long  tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        tree = new long[N*4];

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) ;
            int c = Integer.parseInt(st.nextToken()) ;
//            System.out.println("Arrays.toString(tree) = " + Arrays.toString(tree));
            if(a == 0){
                //sum
                if (b > c) {
                    int temp = b;
                    b = c;
                    c = temp;
                }
                sb.append(sumTree(1, N, 1, b, c) + "\n");
            }else if (a == 1){
                //modify
                modifyTree(1, N, 1, b, c);
            }
        }
        System.out.println(sb.toString());
    }


    private static long sumTree(int start, int end, int node, int left, int right){
        if(left > end || right < start ){
            return  0;
        }


        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) /2;

        return sumTree(start, mid , node *2 , left,right) + sumTree(mid + 1, end, node *2 +1, left,right);
    }
    private static long modifyTree(int start, int end, int node, int target, int num){
        if(target < start || target > end){
            return tree[node];
        } // 인덱스가 범위를 벗어나면 현재값 리턴

        if(start == target && end == target){ // 시작값하고 target이 맞을 때 end가 target하고 맞을 때만 들어옴
            return tree[node] = num;
        }

        int mid = (start + end) /2;

        return tree[node] = modifyTree(start , mid , node *2 , target, num) + modifyTree(mid + 1, end, node * 2 + 1, target, num);
    }

}