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
        
        // place 배열을 char 배열로 변환하여 map에 저장
        for (int i = 0; i < size; i++) {
            map[i] = place[i].toCharArray(); 
        }
        
        // 거리두기 규칙이 지켜졌다면 1, 아니면 0 반환
        return isPossible(map) ? 1 : 0;
    }
    
    private static boolean isPossible(char[][] map) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 'P') {
                    // 사람이 앉아있는 좌표 (i, j)에 대해 거리두기 규칙 확인
                    if (!distanceManhattan(map, i, j)) {
                        return false;  // 거리두기를 지키지 않은 경우
                    }
                }
            }
        }
        return true;  // 모든 사람이 거리두기를 지킴
    }
    
    private static boolean distanceManhattan(char[][] map, int x, int y) {
        // 맨해튼 거리 2 이내의 좌표를 확인
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        // 4방향으로 탐색하여 맨해튼 거리 1의 'P' 확인
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (isValid(nx, ny) && map[nx][ny] == 'P') {
                return false; // 맨해튼 거리 1에 사람이 있으면 거리두기 실패
            }
        }
        
        // 맨해튼 거리 2 확인 (대각선 포함 8방향)
        int[][] checkDist2 = {
            {-2, 0}, {2, 0}, {0, -2}, {0, 2}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        
        for (int[] d : checkDist2) {
            int nx = x + d[0];
            int ny = y + d[1];
            
            if (isValid(nx, ny) && map[nx][ny] == 'P') {
                // 맨해튼 거리 2에 사람이 있으면, 중간에 파티션이 있는지 확인
                if (d[0] == 0) {  // 가로방향
                    if (map[x][(y + ny) / 2] != 'X') {
                        return false; // 파티션 없으면 거리두기 실패
                    }
                } else if (d[1] == 0) {  // 세로방향
                    if (map[(x + nx) / 2][y] != 'X') {
                        return false; // 파티션 없으면 거리두기 실패
                    }
                } else {  // 대각선
                    if (map[x][ny] != 'X' || map[nx][y] != 'X') {
                        return false; // 대각선은 두 경로에 모두 파티션이 있어야 함
                    }
                }
            }
        }
        
        return true; // 거리두기를 잘 지킨 경우
    }
    
    // 유효한 좌표인지 확인하는 함수
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
