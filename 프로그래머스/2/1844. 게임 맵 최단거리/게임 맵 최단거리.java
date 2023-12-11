import java.util.*;
import java.lang.*;


class Solution {
    
    static int map[][];
static boolean visited[][];
static int dx[] = {-1,0,1,0};
static int dy[] = {0,-1,0,1};
static int N, M;
static int result = Integer.MIN_VALUE;
static class move {
    int x, y, cnt;
    public move(int x, int y, int cnt){
    this.x = x;
    this.y = y;
    this.cnt = cnt;
    }
    
}
    
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N ; i++){
            for(int j =0; j < M ; j++){
                map[i][j] = maps[i][j];
            }
        }
        bfs(0,0);
        if(result != Integer.MIN_VALUE ){
            answer = result;
        }else{
            answer = -1;
        }
        
        
        return answer;
    }
    
    private static void bfs(int i , int j){
        Queue<move> q = new LinkedList<>();
        q.add(new move(i,j,0));
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            move now = q.poll();
            
      
            if(now.x == N-1 && now.y == M-1){
              
                result = now.cnt + 1;
                break;
            }
            
            
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new move(nx, ny , now.cnt +1 ));
                    
                }
            }
        }
    }
    
}