import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		
		
		int arr[] = new int[26];
		
		char[] tempArr = temp.toCharArray();
		
		
		for(int i =0; i < tempArr.length; i++) {
			arr[(tempArr[i] - 97)]++;
		}
		
		for(int i =0; i < 26; i++) {
			System.out.print(arr[i] + " ");
		}
				
		
		
	}

}