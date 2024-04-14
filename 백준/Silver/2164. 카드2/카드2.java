import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

      while(q.size() != 1){
            int y= q.poll();
            // System.out.println("버린카드 " + y);
            int x = q.poll();
            // System.out.println("넣은카드 " + x);
            q.add(x);
      }
      System.out.println(q.poll());
    }
}