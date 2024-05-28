import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        int arr[] = new int[N+1];
        int trace[] = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        arr[1] = 0;


        for (int i = 2; i <= N; i++) {

            if( i % 3 == 0){
                if(arr[i/3] + 1 < arr[i]){
                    arr[i] = arr[i /3] + 1;
                    trace[i] = i/3;
                }

            }

            if(i % 2 == 0){
                if(arr[i/2] + 1 < arr[i]){
                    arr[i] = arr[i /2] + 1;
                    trace[i] = i/2;
                }


            }

            if(arr[i -1] + 1 < arr[i]){
                arr[i] = arr[i-1] +1;
                trace[i] = i-1;
            }



        }

        System.out.println(arr[N]);

        while (N > 0){
            sb.append( N + " ");
            N = trace[N];
        }

        System.out.println(sb.toString());
    }
}