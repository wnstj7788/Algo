import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            System.out.println(binarySearch(0, N - 1, Integer.parseInt(st.nextToken())));
        }
    }

    public static int binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return 1; // 찾음
            }
            if (arr[mid] < target) {
                start = mid + 1; // 오른쪽 부분 탐색
            } else {
                end = mid - 1; // 왼쪽 부분 탐색
            }
        }
        return 0; // 찾지 못함
    }
}