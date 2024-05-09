import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];

        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[N + 1];
        dp[1] = arr[1];
        if (N > 1) dp[2] = arr[1] + arr[2]; 

        for (int i = 3; i <= N ; i++) {
            // 한 번에 1칸 혹은 2칸을 오를 수 있으므로, 현재 위치에서 한 칸 혹은 두 칸을 오를 때의 최댓값을 비교
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }
        
        System.out.println(dp[N]);
    }
}