import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		
		int max=0;
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
			for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());	
			P[i]=Integer.parseInt(st.nextToken());
		}//for
		
		int[] dp = new int[N+1];
		
		for(int i=0;i<N;i++) {
			 if(i+T[i]<=N) { // 범위 Check
				 dp[i+T[i]]=Math.max(dp[i+T[i]],dp[i]+P[i]);	
			 }//if
			 dp[i+1]=Math.max(dp[i+1],dp[i]);
			 
		}	
		System.out.println(dp[N]);	
	}
	
}