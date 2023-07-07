import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            PriorityQueue<Long> pq = new PriorityQueue();

            int len = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < len; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            long result = 0;

            while (pq.size() > 1){
                sum = pq.poll() + pq.poll();

                result += sum;

                pq.add(sum);


            }

            sb.append(result).append("\n");


        }
        System.out.println(sb.toString());


    }
}