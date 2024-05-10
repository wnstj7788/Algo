import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int N = Integer.parseInt(br.readLine());
 
		int[][] Cost = new int[N][3];
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
 
			Cost[i][0] = Integer.parseInt(st.nextToken());
			Cost[i][1] = Integer.parseInt(st.nextToken());
			Cost[i][2] = Integer.parseInt(st.nextToken());
 
		}
 
		for (int i = 1; i < N; i++) {
			Cost[i][0] += Math.min(Cost[i - 1][1], Cost[i - 1][2]);
			Cost[i][1] += Math.min(Cost[i - 1][0], Cost[i - 1][2]);
			Cost[i][2] += Math.min(Cost[i - 1][0], Cost[i - 1][1]);
		}
 
		System.out.println(Math.min(Math.min(Cost[N - 1][0], Cost[N - 1][1]), Cost[N - 1][2]));
	}
 
}