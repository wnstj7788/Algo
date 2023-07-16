import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 음주 코딩
 * https://www.acmicpc.net/problem/5676
 */
public class Main {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            tree = new int[n * 4];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > 0) {
                    temp = 1;
                } else if (temp < 0) {
                    temp = -1;
                }
                arr[i] = temp;
            }
            init(1, n, 1);
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (oper.equals("C")) { // update
                    if (v > 0) {
                        v = 1;
                    } else if (v < 0) {
                        v = -1;
                    }
                    update(1, n, 1, i, v);
                } else { // 연산
                    int data = get(1, n, 1, i, v);
                    if (data > 0) {
                        sb.append("+");
                    } else if (data == 0) {
                        sb.append("0");
                    } else {
                        sb.append("-");
                    }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    private static int update(int start, int end, int node, int index, int value) {
        if (start > index || end < index) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = value;
        }
        int mid = (start + end) / 2;
        int l = update(start, mid, node * 2, index, value);
        int r = update(mid + 1, end, node * 2 + 1, index, value);
        return tree[node] = l * r;
    }

    private static int get(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 1;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return get(start, mid, node * 2, left, right) * get(mid + 1, end, node * 2 + 1, left, right);
    }
}