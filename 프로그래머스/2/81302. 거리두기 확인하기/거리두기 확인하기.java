class Solution {
    static final int size = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        
        int i = 0;
        for (String[] place : places) {
            answer[i++] = distance(place); 
        }
        return answer;
    }
    
    private static int distance(String[] place) {
        char[][] map = new char[size][size];
        
        for (int i = 0; i < size; i++) {
            map[i] = place[i].toCharArray(); 
        }
        
        return isPossible(map) ? 1 : 0;
    }
    
    private static boolean isPossible(char[][] map) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 'P') {
                    if (!distanceManhattan(map, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean distanceManhattan(char[][] map, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (isValid(nx, ny) && map[nx][ny] == 'P') {
                return false;
            }
        }
        
        int[][] checkDist2 = {
            {-2, 0}, {2, 0}, {0, -2}, {0, 2}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        
        for (int[] d : checkDist2) {
            int nx = x + d[0];
            int ny = y + d[1];
            
            if (isValid(nx, ny) && map[nx][ny] == 'P') {
                if (d[0] == 0) { 
                    if (map[x][(y + ny) / 2] != 'X') {
                        return false; 
                    }
                } else if (d[1] == 0) {  
                    if (map[(x + nx) / 2][y] != 'X') {
                        return false; 
                    }
                } else {
                    if (map[x][ny] != 'X' || map[nx][y] != 'X') {
                        return false; 
                    }
                }
            }
        }
        
        return true;
    }
    
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
