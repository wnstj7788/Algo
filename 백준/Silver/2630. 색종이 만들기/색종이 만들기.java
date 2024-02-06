import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
 
public class Main {
	public static int white, blue;
	public static int[][] board;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void dfs(int x, int y, int size) {
		
		//
		if(Check(x, y, size ) == 1) {
			if(board[x][y] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int newSize = size / 2;

		dfs(x, y, newSize);
		dfs(x, y + newSize, newSize);
		dfs(x + newSize, y, newSize);
		dfs(x + newSize, y + newSize, newSize);
	}

	public static int Check(int row, int col, int size) {
	
		int color = board[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {

				if(board[i][j] != color) {
					return 0;
				}
			}
		}

		return 1;
	}
}