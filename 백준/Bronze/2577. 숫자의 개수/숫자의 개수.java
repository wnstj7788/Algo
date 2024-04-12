import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result = 1;
		
		for(int i = 0; i < 3; i ++) {
			result *= Integer.parseInt(br.readLine());
		}
		
		String resultString = String.valueOf(result);
		
		int arr[] = new int[10];
		
		for (int i = 0; i < resultString.length(); i++) {
			char temp = resultString.charAt(i);
			arr[temp - '0']++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}