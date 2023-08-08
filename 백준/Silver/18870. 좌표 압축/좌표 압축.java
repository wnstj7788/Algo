import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> ranking = new HashMap<>();

        int real[] = new int[N];
        int sorted[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            real[i] = temp;
            sorted[i] = temp;
        }

        Arrays.sort(sorted);
        // -10, -9 ,2 ,4 ,4

        int rank = 0;
        for (int v : sorted) {
            /*
             *  이 때 만약 앞선 원소가 이미 순위가 매겨졌다면
               불필요한 연산을 막음 
                           *  
             */
            if (!ranking.containsKey(v)) {
                ranking.put(v, rank);
                rank++;
            }
            
        }
        
        // map -> 0(-10), 1(-9), 2(2), 3(4)

        StringBuilder sb = new StringBuilder();
        for (int key : real) {
            int ranked = ranking.get(key);    // 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(ranked).append(' ');
        }

        System.out.println(sb);


    }
}