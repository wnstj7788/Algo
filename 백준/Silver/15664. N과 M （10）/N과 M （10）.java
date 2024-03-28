import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int card[];
	static int result[];
	static boolean visited[];
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(card);
		
		dfs(0,0);
		
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int idx, int depth) {
		if(depth == M) {
			for(int temp : result) {
				sb.append(temp + " ");
			}
			sb.append("\n");
			return; 
		}
		
		int temp = 0;
		for (int i = idx; i < N; i++) {
			if(temp != card[i]) {
				if(!visited[i]) {
					visited[i] = true;
					result[depth] = card[i];
					temp = result[depth];
					dfs(i ,depth +1);
					visited[i] = false;
					
				}
			}
			
			
			
			
	
		}
	}

}