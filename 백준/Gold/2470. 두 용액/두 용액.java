import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        twoPointer(map);
    }

    private static void twoPointer(int[] map) {
        // Initialize left and right pointers
        int left = 0;
        int right = map.length - 1;

        // Initialize answer variables
        int minSum = Integer.MAX_VALUE;
        int answerLeft = left;
        int answerRight = right;

        while (left < right) {
            int sum = map[left] + map[right];

            // Update answer if needed
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                answerLeft = left;
                answerRight = right;
            }

            // Move pointers
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(map[answerLeft] + " " + map[answerRight]);
    }
}