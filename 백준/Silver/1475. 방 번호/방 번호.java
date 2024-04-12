import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int cnt = 0;
		
		// 9 랑 6을 똑같음 
		//2개까지는 똑같음 //2 하면 될 듯

		
		int arr[]= new int[10];
		
		for (int i = 0; i < temp.length(); i++) {
			char tempChar = temp.charAt(i);
			
			if(tempChar - '0' == 6) {
				arr[9] ++;
				
			}else {
				arr[tempChar - '0']++;
			}
		}
		
		int result = 0;
		
		arr[9] = arr[9]/ 2 + arr[9]%2;
		
		
		
		for (int i = 0; i < arr.length; i++) {
			result = Math.max(arr[i], result);
		}
		System.out.println(result);
		
		
		 
		
		
		
		
	}

}