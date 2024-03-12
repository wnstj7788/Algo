import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 사과 먹으면 뱀의 길이가 늘어남
	 * 이리 저리 기어다니다가 벽 또는 자기 자신의 몸과 부딛히면 게임이 끝남
	 * N * N 사과가 놓여있는 곳들이 있음 
	 * 상하좌우 끝에 벽이 있다 
	 * 뱀은 맨좌측 위치하고 길이는 1이다 
	 * 초다마 이동 
	 * 길이를 늘려 머리를 다음칸 위치 
	 * 벽이나 자기자신 게임 끝남 
	 * 이동칸 사과가 있다면 사과가 없어지고 꼬리는 움직이지 않는다  -> 머리를 늘림 
	 * 사과가 없다면 몸길이를 줄여 꼬리가 위치한 칸을 비워준다. 몸길이는 변하지 않음
	 */
	
	/*
	 * 보드의 길이 N 
	 * 사과 위치 
	 * 뱀의 방향 변환 횟수 L 
	 * 시간 좌우 변화 제공 
	 */

	// 1. 범위체크
	// 2. 사과 있 없 체크 
	// 이동 체크
	
	private static class Move{
		int x; 
		int y;
		
		private Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 동 남 서 북
	static int board[][];
	static int N;
	static HashMap<Integer, String> map = new HashMap<>();
	static Queue<Move> snack = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		int len = Integer.parseInt(br.readLine());
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1 ;
			int b = Integer.parseInt(st.nextToken()) -1 ;
			board[a][b] = 1; // 사과 
		}
		
		len = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			map.put(time, dir);
		}
		
		System.out.println(Solution());
		
		
		
	}
	
	private static int Solution() {
		int nowX = 0;
		int nowY = 0;
		int time = 0;
		int dir = 0;
		snack.add(new Move(0,0));
		
		while(true) {
			time++; //시간 gogo 
			
			int nextX = nowX + dx[dir];
			int nextY = nowY + dy[dir];
			
			
			
			if(!check(nextX, nextY)) // 범위 및 자기 몸
				break;
			
			if(board[nextX][nextY] == 1) {
				board[nextX][nextY] = 0; // 사과 먹음 
				snack.add(new Move(nextX, nextY));
			}else { // 사과 없는 경우 
				//이동 후 자르기 
				snack.add(new Move(nextX, nextY));
				snack.poll();
				
			} // 움직이기 끝 
			
			//시간초 
			if(map.containsKey(time)) {
				// 해당하는 시간에 움직임이 있다면 
				String D = map.get(time);
				if(D.equals("D")){
					dir += 1; // 오른쪽
					if (dir == 4)
						dir = 0;
				}else {
					dir -=1; // 왼쪽
					if(dir == -1) {
						dir = 3;
					}
				}
			}
			
			nowX = nextX;
			nowY = nextY;
			
		
		}
		
		return time;
	}
	
	
	private static boolean check(int x, int y) {
		if(N > x && x >= 0 && N > y && y >=0 ) {
			//범위 안에 있음 
			
			Iterator<Move> iter = snack.iterator();
			while(iter.hasNext()) {
				Move now = iter.next();
				if(now.x == x && now.y == y) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}

}