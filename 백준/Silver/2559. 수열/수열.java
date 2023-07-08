import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(slidingWindow());


    }

    private static int slidingWindow() {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i]; // 값은 계속 갱신해야함
            if (i == M - 1) {
                max = sum; // 처음 최대값 저장
            }

            if (i >= M) {
                sum -= arr[i - M];
                max = Math.max(max, sum);
            }

        }
        return max;

    }

}