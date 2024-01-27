import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC ; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 전부 1인거 만들고 101010101101111 비교하기
            //               000000000001111 bit N
            int bit = (1 << (N)) - 1;
            if( bit == (M & bit)){
                System.out.println("#" + i + " " + "ON");
            }else{
                System.out.println("#" + i + " " + "OFF");
            }

        }

    }
}