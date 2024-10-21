import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        int startX = 0;
        int startY = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 심장 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*' && !flag) {
                    flag = true;
                    startY = i + 1; // 심장 위치는 머리 아래 1칸
                    startX = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(startY + 1).append(" ").append(startX + 1).append("\n");

        // 왼쪽 팔 길이
        int leftArm = 0;
        for (int i = startX - 1; i >= 0; i--) {
            if (board[startY][i] == '*') {
                leftArm++;
            } else {
                break;
            }
        }
        sb.append(leftArm).append(" ");

        // 오른쪽 팔 길이
        int rightArm = 0;
        for (int i = startX + 1; i < N; i++) {
            if (board[startY][i] == '*') {
                rightArm++;
            } else {
                break;
            }
        }
        sb.append(rightArm).append(" ");

        // 허리 길이
        int waist = 0;
        int hx = startX, hy = startY;
        for (int i = startY + 1; i < N; i++) {
            if (board[i][startX] == '*') {
                waist++;
                hy = i; // 허리가 끝나는 위치를 저장
            } else {
                break;
            }
        }
        sb.append(waist).append(" ");

        // 왼쪽 다리 길이
        int leftLeg = 0;
        for (int i = hy + 1; i < N; i++) {
            if (board[i][startX - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }
        sb.append(leftLeg).append(" ");

        // 오른쪽 다리 길이
        int rightLeg = 0;
        for (int i = hy + 1; i < N; i++) {
            if (board[i][startX + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }
        sb.append(rightLeg);

        System.out.println(sb.toString());
    }
}