import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    private static int makeTable(String str){
        int len = str.length();
        int table[] = new int[str.length()];

        int j = 0;
        int cnt = 0;

        for (int i = 1; i < len; i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                // 일치하지 않는다면 table 전 값으로 돌림
                // 0 0 1 2 3 0 이였다면 이전 값으로  3으로 다시 가있는거임
                j = table[j -1];
            }
            if(str.charAt(i) == str.charAt(j)){
                table[i] = ++j;
                cnt = Math.max(cnt, table[i]);

            }
        }
        if(len % (len- table[len -1]) != 0){
            return  1;
        }else{
            return len / (len - table[len -1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        while(true){ // 점이면 멈춰!
            String temp = br.readLine();
            if(temp.equals(".")){
                break;
            }else{
                System.out.println(makeTable(temp));
            }

        }

    }
}