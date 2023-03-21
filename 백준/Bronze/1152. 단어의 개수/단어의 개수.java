import java.util.*;
import java.util.Scanner;
//공백 하나 입력을 고려 
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();

		
		String trimstr = str.trim();
			
		String[] list = trimstr.split(" ");
		
		if(list[0].equals("")){
			System.out.println("0");
		}else {
		
			System.out.println(list.length);
		
		}
	}
}
	


	



