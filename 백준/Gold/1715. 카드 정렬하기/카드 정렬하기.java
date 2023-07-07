import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue();

        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i < len; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        int result = 0;

        while (pq.size() > 1){
            sum = pq.poll() + pq.poll();

            result += sum;

            pq.add(sum);


        }

        System.out.println(result);

    }
}