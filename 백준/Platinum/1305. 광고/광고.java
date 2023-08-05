import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int makeTable(String str, int N){
        int len = N;
        int[] table = new int[len];
        int cnt = 0;

        int j = 0;

        for (int i = 1; i <len ; i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = table[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                table[i] = ++j;

            }
        }

        return table[len -1]; //
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(N- makeTable(str,N));

    }
}