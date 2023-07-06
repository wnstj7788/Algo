import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;

        int right = 0;

        int sum = 0;

        int cnt = 0;

        while(true){

            if(sum >= target){
                sum -= arr[left];
                left++;
            }else if(right > len -1){
                break;
            }else{
                sum += arr[right];
                right++;
            }

            if(sum == target){
                cnt++;

            }

        }

        System.out.println(cnt);




    }
}
