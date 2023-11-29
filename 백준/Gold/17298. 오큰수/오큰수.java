import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // N => A ----An
    // Ai보다 오른쪽에 있으면서 Ai 보다 큰 수 중에서 가장 왼쪽에 있는 수  그런 수가 없으면 -1
    // 3 5 2 7
    // 1(5) 2(7) 3(7) 4(-1)
    // 슬라이딩 윈도우가 생각나네요..?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++) {

            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

 
        while(!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);




//        int [] data  = new int[len];
//        for (int i = 0; i < len; i++) {
//            data[i] = Integer.parseInt(st.nextToken());
//        }
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < len ; i++) {
//            start = data[i];
//            if(i == len -1){
//                sb.append(-1 + " ");
//                break;
//            }
//            for (int j = i+1; j < len ; j++) {
//                end = data[j];
//                if(start < end){
//                    sb.append(end + " ");
//                    break;
//                }
//                if(j == len -1){
//                    sb.append(-1 + " ");
//                }
//            }
//        }

       

    }
}