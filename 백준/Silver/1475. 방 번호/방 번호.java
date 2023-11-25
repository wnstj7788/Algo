import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 - 9까지 1set = 최소 set을 구해라
6 - 9 는 뒤집어서 사용할 수 있다.

step1. 1-9 배열 생성 초기 값 0
step2. 현재값이 6인지 9인지 확인

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int size = str.length();
        int[] arr = new int[10];
        int temp = 0;
        int max = 0;

        //counting 배열을 사용하였다.
        for (int i = 0; i < size; i++) {
            temp = str.charAt(i) - '0';
            arr[temp]++;

        }


        int k = (arr[6] + arr[9]);
        //6,9의 합이 짝수이면 반으로 나누면 된다.
        if (k % 2 == 0) {
            arr[6] = k / 2;
            arr[9] = k / 2;
        } else {
            arr[6] = k / 2 + 1;
            arr[9] = k / 2 + 1;
        }
        //반복해서 최대값을 찾는다.
        for (int i : arr) {
            max = Math.max(max, i);
        }
        System.out.println(max);



    }
}