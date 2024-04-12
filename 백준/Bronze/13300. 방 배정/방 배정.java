import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[2][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[s][y - 1]++; 
		}
		
		
		int result = 0;
		
		for(int i =0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(map[i][j] == 0) {
					
				}else {
					if(map[i][j] < M) {
						result++;
					}else {
						if(map[i][j] % M !=0 ) {

							result = result + map[i][j] / M + 1;  
						}
						else {
							result += map[i][j] / M;
						}
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}