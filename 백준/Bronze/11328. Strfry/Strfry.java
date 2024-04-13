import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  int N = Integer.parseInt(br.readLine());
	  
	
	  
	  
	  StringTokenizer st;
	  
	  for(int i =0; i < N ; i++) {
		  
		  st = new StringTokenizer(br.readLine());
		  int arr[] = new int[26];
		  
		  String A = st.nextToken();
		  
		  for(int j = 0; j < A.length(); j++) {
			 char temp = A.charAt(j);
			 arr[temp - 'a']++;
		  }
		  
		  String B = st.nextToken();
		  
		  for(int j = 0; j < B.length(); j ++) {
			  char temp = B.charAt(j);
			  arr[temp -'a']--;
		  }
		  boolean check = false;
		  
		  for (int k = 0; k < 26; k++) {
				if(arr[k] != 0) {
					check = true;
				}
			}
		  System.out.println(check ? "Impossible" :"Possible" );
	  }
	  

	  
	}

}

//   a a b b   a a  a  b b b