import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            String preFix = arr[i];
            for (int j = i + 1; j < N; j++) {
                if(arr[j].startsWith(preFix)) {
                    arr[i] = null;

                    break;
                }
            }
        }

        int cnt = 0;

        for(String str : arr) {
            if(str == null){
                cnt++;
            }
        }

        System.out.println(N - cnt);



    }
}