import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int arr[];
    static TreeSet<Integer> ts;
    static Map<Integer, Integer> tm;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ts = new TreeSet<>();
        
        
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp; 
            ts.add(temp);  
        }

        tm = new HashMap<>();
        int index = 0;

    
        for (int value : ts) {
            tm.put(value, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(tm.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}