import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N + 1];
		
		int dp[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		dp[1] = arr[1];		
		for (int i = 1; i <= N; i++) {
			if( i > 1) {
				dp[2] = arr[1] + arr[2];
			}
		}
		
		
		/*
		  와인 복용이 가능한 경우 
		  1. 전 와인을 먹고 현재 와인 먹기
		  2. 전전 와인 먹고 현재 와인을 먹는 경우 
		  
		  전전전까지의 최대량 + 전번째 양 +현재 양
		   A  X X A A
		   
		   A  X  A
		   
		   3. 전까지의 최대양 + 현재 와인을 마시지 않는 경우 
		   
		   OOX
		   OXO
		   XOO
		 */
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i -1 ], Math.max(dp[i -2] + arr[i], dp[i -3] + arr[i -1] + arr[i]));
		}
		
		System.out.println(dp[N]);
		
		
		
		
	}

}