import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if("push".equals(command)){
                int x = Integer.parseInt(st.nextToken());
                last = x;
                q.add(x);

            }else if("pop".equals(command)){
                if(!q.isEmpty()){
                    sb.append(q.poll() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }else if("size".equals(command)){
                sb.append(q.size() + "\n");
                
            }else if("empty".equals(command)){
                if(!q.isEmpty()){
                    sb.append(0 + "\n");
                }else{
                    sb.append(1 + "\n");
                }
                
            }else if("front".equals(command)){
                if(!q.isEmpty()){
                    sb.append(q.peek()+ "\n");
                }else{
                    sb.append(-1 + "\n");
                }
                
            }else if("back".equals(command)){
                if(!q.isEmpty()){
                    sb.append(last+ "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}