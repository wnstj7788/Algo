import java.util.*;

class Solution {
    static int Xmax, Ymax;

    public int solution(int[][] beginning, int[][] target) {
        Xmax = beginning.length;
        Ymax = beginning[0].length;

        int answer = Integer.MAX_VALUE;

        // 각 행에 대해 비트마스크를 적용하여 모든 가능한 상태를 확인
        for (int rowMask = 0; rowMask < (1 << Xmax); rowMask++) {
            for (int colMask = 0; colMask < (1 << Ymax); colMask++) {
                int flips = countFlips(rowMask, colMask, beginning, target);
                if (flips != -1) {
                    answer = Math.min(answer, flips);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // rowMask와 colMask를 이용해 최소 뒤집기 횟수 계산
    public static int countFlips(int rowMask, int colMask, int[][] beginning, int[][] target) {
        int flipCount = 0;
        int[][] newState = copyArray(beginning);

        // rowMask에 따라 행을 뒤집기
        for (int r = 0; r < Xmax; r++) {
            if ((rowMask & (1 << r)) != 0) {  // r번째 비트가 1이면 해당 행을 뒤집음
                newState = flipRow(newState, r);
                flipCount++;
            }
        }

        // colMask에 따라 열을 뒤집기
        for (int c = 0; c < Ymax; c++) {
            if ((colMask & (1 << c)) != 0) {  // c번째 비트가 1이면 해당 열을 뒤집음
                newState = flipColumn(newState, c);
                flipCount++;
            }
        }

        // 뒤집은 후 상태가 target과 일치하는지 확인
        if (Arrays.deepEquals(newState, target)) {
            return flipCount;  // 일치하면 뒤집기 횟수를 반환
        }
        return -1;  // 일치하지 않으면 -1 반환
    }

    // 행을 뒤집는 함수
    private static int[][] flipRow(int[][] arr, int row) {
        int[][] newArr = copyArray(arr);
        for (int i = 0; i < newArr[row].length; i++) {
            newArr[row][i] = 1 - newArr[row][i];  // 0을 1로, 1을 0으로 변경
        }
        return newArr;
    }

    // 열을 뒤집는 함수
    private static int[][] flipColumn(int[][] arr, int col) {
        int[][] newArr = copyArray(arr);
        for (int i = 0; i < newArr.length; i++) {
            newArr[i][col] = 1 - newArr[i][col];  // 0을 1로, 1을 0으로 변경
        }
        return newArr;
    }

    // 배열을 복사하는 함수
    private static int[][] copyArray(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }
}
