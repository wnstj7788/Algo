import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }



        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(!arr[i].equals("KBS1")){
                sb.append(1);
                cnt++;
            }else{
                arr = swap(arr, i, cnt, 0);
                break;
            }
        }


        cnt = 0;
        for (int i = 0; i < N; i++) {
            if(arr[1].equals("KBS2")){
                break;
            }
            if(!arr[i].equals("KBS2")){
                sb.append(1);
                cnt++;
            }else{
                arr = swap(arr, i, cnt, 1);
                break;
            }
        }
//
//        for(String s : arr){
//            System.out.println(s);
//        }
        System.out.println(sb.toString());

    }


    public static String[]  swap(String[] arr, int i, int cnt, int index){
        for(int C = cnt; C > index ; C--){
            String temp = arr[C];
            arr[C] = arr[C-1];
            arr[C-1] = temp;
            sb.append(4);
        }
        return  arr;
    }
}