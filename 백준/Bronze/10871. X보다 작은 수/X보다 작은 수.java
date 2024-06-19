import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int temp = list.get(i);
            if(temp < X){
                sb.append(temp + " ");
            }
        }

        // Iterator<Integer> iter = list.iterator(); // 	15424 - 메모리	132 - 시간 

        // while(iter.hasNext()){
        //     Integer temp = iter.next();
        //     if(temp < X){
        //         sb.append(temp + " ");
        //     }
        // }

        System.out.println(sb.toString());
    

    
    }
}