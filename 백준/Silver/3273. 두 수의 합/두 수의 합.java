import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0; i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int x = Integer.parseInt(br.readLine());
		int result[] = new int[x + 1];
		
		
		int answer = 0;
		
		// result 1 2 3 4 5 6 7 8 9 10 11 12 13
		// arr [5 12 7 10 9  1 2 3  11] 
		
		for (int i = 0; i < N; i++) {
			if((x- arr[i]) >= 0 && result[x - arr[i]] == 1) {
				
				answer++;
			}else if(arr[i] <= x){
				result[arr[i]] = 1;
			}
		}
		
		System.out.println(answer);
		
		
		
	}
	
	// 13 - 12 = 1

}