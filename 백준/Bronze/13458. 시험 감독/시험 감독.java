import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 int N = Integer.parseInt(br.readLine());
	 
	 int map[] = new int[N];
	 
	 st = new StringTokenizer(br.readLine());
	 for (int i = 0; i < N; i++) {
		 map[i] = Integer.parseInt(st.nextToken());
		
	}
	 st = new StringTokenizer(br.readLine());
	 int A = Integer.parseInt(st.nextToken());
	 int B = Integer.parseInt(st.nextToken());
	 
	 
	 long result = 0;
	
	 
	 for (int i = 0; i < N; i++) {
		 int target = map[i];
		 
		 target -= A;
		
		 result++;
		 if(target < 0) {
			 target = 0;
		 }
		 
	
		int number = target / B;
		result += number;
		
		if(target % B > 0) {
			result++;
		}
			 	 
	}
	 System.out.println(result);
	 
	 
	 
	}

}