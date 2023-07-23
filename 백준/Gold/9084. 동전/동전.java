import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int coin[] = new int[n+1]; //Coin 종류
            for (int i = 1; i <= n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            // 코인 입력 끝


            int m = Integer.parseInt(br.readLine()); // 목표 금액

            int dp[] = new int[m +1]; // 목표 금액까지 전부 만듬

            for (int i = 1; i <=n ; i++) { // 코인당
                for (int j = 1; j <=m ; j++) { // 목표 금액까지
                    if(j-coin[i] > 0){ //현재 금액에서 현재 코인을 뺀 가격이 0보다 크다면

                        dp[j] = dp[j] + dp[j-coin[i]];

                    }else if(j -coin[i] == 0){
                        dp[j] ++;
                    }
                }
            }
            sb.append(dp[m] + "\n");
        }
        System.out.println(sb.toString());
    }
}