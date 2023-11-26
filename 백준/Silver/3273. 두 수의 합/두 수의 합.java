import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
    // ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
    // 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int arr[] = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(br.readLine());
        for (int i = 0; i <len ; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i <len ; i++) {
            for (int j = i + 1; j <len ; j++) {
               if(target == arr[i] + arr[j]){
                   answer++;
                   break;
               }
            }
        }

        System.out.println(answer);
    }
}