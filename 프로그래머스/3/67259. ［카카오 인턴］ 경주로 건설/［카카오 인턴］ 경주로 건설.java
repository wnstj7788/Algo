import java.util.*;

class Solution {
    static class Car {
        int x, y, score, d;
        public Car(int x, int y, int score, int d) {
            this.x = x;
            this.y = y;
            this.score = score;
            this.d = d;
        }
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        int answer = Math.min(minCost(board, 0, cost), minCost(board, 3, cost));
        return answer;
    }
    
    private int minCost(int[][] board, int startDir, int[][][] cost) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int N = board.length;
        Queue<Car> moveQueue = new LinkedList<>();
        
        cost[0][0][startDir] = 0;
        moveQueue.add(new Car(0, 0, 0, startDir));
        
        int result = Integer.MAX_VALUE;
        while (!moveQueue.isEmpty()) {
            Car now = moveQueue.poll();
            
            if (now.x == N - 1 && now.y == N - 1) {
                result = Math.min(result, now.score);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                    int newCost = now.score + ((now.d == i) ? 100 : 600);
                    if (newCost < cost[nx][ny][i]) {
                        cost[nx][ny][i] = newCost;
                        moveQueue.add(new Car(nx, ny, newCost, i));
                    }
                }
            }
        }
        
        return result;
    }
}
