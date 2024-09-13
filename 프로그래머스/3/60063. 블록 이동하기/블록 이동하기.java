import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N;

    static class Robot {
        int x1, y1, x2, y2, cnt;
        Robot(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] board) {
        N = board.length;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = board[i][j];
            }
        }

        // BFS 시작
        return bfs();
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && map[x][y] == 0;
    }

    public static int bfs() {
        Queue<Robot> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][N][N]; // 두 칸의 좌표에 대한 방문 체크

        // 로봇은 (0, 0)과 (0, 1)에서 시작
        queue.add(new Robot(0, 0, 0, 1, 0));
        visited[0][0][0][1] = true;

        while (!queue.isEmpty()) {
            Robot robot = queue.poll();

            int x1 = robot.x1, y1 = robot.y1;
            int x2 = robot.x2, y2 = robot.y2;
            int cnt = robot.cnt;

            // 목표 지점에 도달하면 종료
            if ((x1 == N - 1 && y1 == N - 1) || (x2 == N - 1 && y2 == N - 1)) {
                return cnt;
            }

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

                if (isValid(nx1, ny1) && isValid(nx2, ny2) && !visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.add(new Robot(nx1, ny1, nx2, ny2, cnt + 1));
                }
            }

            // 회전 (가로 상태일 때 세로로, 세로 상태일 때 가로로)
            if (x1 == x2) { // 로봇이 가로로 놓여 있을 때
                // 위쪽으로 회전
                if (isValid(x1 - 1, y1) && isValid(x2 - 1, y2)) {
                    if (!visited[x1 - 1][y1][x1][y1]) {
                        visited[x1 - 1][y1][x1][y1] = true;
                        queue.add(new Robot(x1 - 1, y1, x1, y1, cnt + 1));
                    }
                    if (!visited[x2 - 1][y2][x2][y2]) {
                        visited[x2 - 1][y2][x2][y2] = true;
                        queue.add(new Robot(x2 - 1, y2, x2, y2, cnt + 1));
                    }
                }
                // 아래쪽으로 회전
                if (isValid(x1 + 1, y1) && isValid(x2 + 1, y2)) {
                    if (!visited[x1 + 1][y1][x1][y1]) {
                        visited[x1 + 1][y1][x1][y1] = true;
                        queue.add(new Robot(x1 + 1, y1, x1, y1, cnt + 1));
                    }
                    if (!visited[x2 + 1][y2][x2][y2]) {
                        visited[x2 + 1][y2][x2][y2] = true;
                        queue.add(new Robot(x2 + 1, y2, x2, y2, cnt + 1));
                    }
                }
            } else { // 로봇이 세로로 놓여 있을 때
                // 왼쪽으로 회전
                if (isValid(x1, y1 - 1) && isValid(x2, y2 - 1)) {
                    if (!visited[x1][y1 - 1][x1][y1]) {
                        visited[x1][y1 - 1][x1][y1] = true;
                        queue.add(new Robot(x1, y1 - 1, x1, y1, cnt + 1));
                    }
                    if (!visited[x2][y2 - 1][x2][y2]) {
                        visited[x2][y2 - 1][x2][y2] = true;
                        queue.add(new Robot(x2, y2 - 1, x2, y2, cnt + 1));
                    }
                }
                // 오른쪽으로 회전
                if (isValid(x1, y1 + 1) && isValid(x2, y2 + 1)) {
                    if (!visited[x1][y1 + 1][x1][y1]) {
                        visited[x1][y1 + 1][x1][y1] = true;
                        queue.add(new Robot(x1, y1 + 1, x1, y1, cnt + 1));
                    }
                    if (!visited[x2][y2 + 1][x2][y2]) {
                        visited[x2][y2 + 1][x2][y2] = true;
                        queue.add(new Robot(x2, y2 + 1, x2, y2, cnt + 1));
                    }
                }
            }
        }

        return 0;
    }
}
