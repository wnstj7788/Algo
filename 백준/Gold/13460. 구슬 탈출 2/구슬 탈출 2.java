import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int holeX, holeY;
	static Marble blue, red;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());		
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		// 구슬 map 구성 
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				} else if(map[i][j] == 'B') {
					blue = new Marble(0, 0, i, j, 0);
				} else if(map[i][j] == 'R') {
					red = new Marble(i, j, 0, 0, 0);
				}
			}
		}

		System.out.println(bfs());
		
		br.close();
	}
	
	public static int bfs() {
		Queue<Marble> queue = new LinkedList<>();
		queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
		visited[red.rx][red.ry][blue.rx][blue.ry] = true;
		
		while(!queue.isEmpty()) {
			Marble marble = queue.poll();
			
			int curRx = marble.rx;
			int curRy = marble.ry;
			int curBx = marble.bx;
			int curBy = marble.by;
			int curCnt = marble.cnt;
		
			if(curCnt > 10) { 
				return -1;
			}
			
			for(int i = 0; i < 4; i++) {
				int newRx = curRx;
				int newRy = curRy;
				int newBx = curBx;
				int newBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				// 빨간 구슬 이동  
				while(map[newRx + dx[i]][newRy + dy[i]] != '#') { 
					newRx += dx[i];
					newRy += dy[i];
					
					// 이동 중 구멍을 만날 경우 
					if(newRx == holeX && newRy == holeY) { 
						isRedHole = true;
						break;
					}
				}
				
				// 파란 구슬 이동
				while(map[newBx + dx[i]][newBy + dy[i]] != '#') { 
					newBx += dx[i];
					newBy += dy[i];
					
					// 이동 중 구멍을 만날 경우 
					if(newBx == holeX && newBy == holeY) { 
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // 파란 구슬이 구멍에 빠지면 무조건 실패 
					continue; 
				}
				
				if(isRedHole && !isBlueHole) { // 빨간 구슬만 구멍에 빠지면 성공 
					return curCnt;
				}
				
				
				if(newRx == newBx && newRy == newBy) {
					if(i == 0) { // 위쪽으로 기울이기 
					
						if(curRx > curBx) newRx -= dx[i]; 
						else newBx -= dx[i];
					} else if(i == 1) { // 오른쪽으로 기울이기 
						 
						if(curRy < curBy) newRy -= dy[i];
						else newBy -= dy[i];	
					} else if(i == 2) { // 아래쪽으로 기울이기 
						
						if(curRx < curBx) newRx -= dx[i]; 
						else newBx -= dx[i];
					} else { // 왼쪽으로 기울이기 
					
						if(curRy > curBy) newRy -= dy[i]; 
						else newBy -= dy[i];	
					}
				}
				
			
				if(!visited[newRx][newRy][newBx][newBy]) {
					visited[newRx][newRy][newBx][newBy] = true;
					queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
				}
			}
		}
		
		return -1;
	}

}

class Marble {
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;
	
	Marble(int rx, int ry, int bx, int by, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}