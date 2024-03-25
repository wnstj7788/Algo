import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr= new int[M];
//		visited = new boolean[N];
		
		
		permutation(1 , 0, M, N);
		
		
		System.out.println(sb.toString());
	}
	
	
	
	public static void permutation(int idx, int depth, int M, int N) {
		if(depth == M) {
			for (int temp : arr) {
				sb.append(temp + " ");
			}
			sb.append("\n");	
			return;
		}
		
		for (int i = idx; i <= N ; i++) {
			arr[depth] = i ;
			permutation(i +1 , depth + 1, M, N);
		}
	
		
		
	}

}


/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	77303	57716	40926	74.042%
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.


1 2
1 3
1 4
2 3
2 4
3 4
*/