import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    // 검증 로직 -> 시간 초과


    // OR 연산 로직

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        int targetNumber = (1 << 10) - 1;

        for(int i = 1; i <= testcase ; i ++){
            int N = Integer.parseInt(br.readLine()); // 양

            int number = 0;
            int count = 0;
            for (count=1;; count++) {
                char[] arr = String.valueOf(N * count).toCharArray(); //char 배열로 만들기
                for( char c :arr){
                    int num = c - '0'; // 하나한 숫자로 만들기
                    number = number | (1 << num); // oR 연산으로 해당 값 배로 만들어
                }

                if (number == targetNumber) break;
            }
            sb.append("#" + i + " " + N*count);
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }
}