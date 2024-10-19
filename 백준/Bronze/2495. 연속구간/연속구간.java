import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < 3; i ++){
            String number = br.readLine();
            char[] numberchar = number.toCharArray();
            int start = 0;
            int result = 0;
            while(start < numberchar.length){
                int end = start + 1;
                int cnt = 1;
                while(end < numberchar.length && numberchar[end] == numberchar[end -1]){
                    cnt++;
                    end++;

                }
                start = end;
                result = Math.max(result, cnt);
            }

            sb.append(result + "\n");

        }

        System.out.print(sb);
    }
}