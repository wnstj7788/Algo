import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); int k = sc.nextInt();
		
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] =sc.nextInt();
		}
		
		int cnt = 0;
		// 0이 될 때 까지
		// 마지막 요소로 나누어 진다면 k를 마지막 요소로 나누고 cnt 추가 및 나머지 값 저장
		// 나머지 값을 다음 요소로 나누고 ...... 0이 될 떄까지 
	
		for(int j = n-1 ; j >= 0; j--) {
			if( k >= arr[j]) {
				cnt += (k /arr[j]);
				k = k % arr[j];
				}
		
				
			}
		System.out.println(cnt);
		}

	}

