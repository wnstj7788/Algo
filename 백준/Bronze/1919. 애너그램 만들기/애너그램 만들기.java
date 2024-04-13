import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A  = br.readLine();
		String B =  br.readLine();
		
		int arr[] = new int[26];
		
		Arrays.fill(arr,1000);
		
		
		char tempA[] = A.toCharArray();
		
		for(char temp : tempA) {
			arr[temp -'a']++;
		}
		
		char tempB[] = B.toCharArray();
		
		for(char temp : tempB) {
			arr[temp - 'a']--;
		}
		
		int result = 0;
		
		for (int i = 0; i < 26; i++) {
			if(arr[i] != 1000) {
				result += Math.abs(1000 - arr[i]);
			}
		}
		
		
		System.out.println(result);
	}

}