import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int last = 0;  // Move the declaration outside the loop and initialize it to 0

        for(int i = 0; i < len; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push")){
                last = Integer.parseInt(st.nextToken());
                q.add(last);
            } else if(command.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.peek() + "\n");
                }
            } else if (command.equals("back")) {
                if(q.isEmpty()){
                    sb.append(-1 + "\n");
                } else {
                    sb.append(last + "\n");
                }
            } else if (command.equals("size")) {
                sb.append(q.size() + "\n");
            } else if (command.equals("empty")){
                if(q.isEmpty()){
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (command.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}