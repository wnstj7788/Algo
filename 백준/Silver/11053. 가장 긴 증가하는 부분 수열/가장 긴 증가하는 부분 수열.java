import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i <= n; i++) {
            // 4 3 2 4 1 5
            for (int j = 1; j < i; j++) {
                //  2 > 4
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                // dp[1,1,1,1,1,1,1,1,1,1]
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}