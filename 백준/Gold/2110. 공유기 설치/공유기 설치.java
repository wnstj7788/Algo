import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static int home[];
    public static void main(String[] args) throws IOException {
        StringBuilder sb;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);


        int low = 1;
        int upper = home[N-1] - home[0] + 1;

        while(low < upper){
            int mid = (low + upper) /2;

            if(binarySearch(mid) < M ){
                upper = mid;
            }else{
                low = mid + 1;
            }

        }
        System.out.println(low -1);
    }

    private static int binarySearch(int mid) {

        int cnt = 1;
        int lastLocate = home[0];

        for (int i = 0; i <home.length ; i++) {
            int locate = home[i];

            if(locate - lastLocate >= mid){
                cnt++;
                lastLocate = locate;
            }
        }
        return cnt;
    }


}