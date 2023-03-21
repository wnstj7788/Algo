import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	//String s = bf.readLine(); //문자열 입력 
	int n = Integer.parseInt(bf.readLine());
	for(int i = 1; i <=n; i++) {
		for( int j =1; j<= i; j++) {
			System.out.printf("*");
		}
		System.out.println();
	}
	
}	
}