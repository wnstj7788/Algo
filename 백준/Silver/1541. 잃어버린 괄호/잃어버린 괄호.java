import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-"); //습관 1 문자를 자를 때 꼭 Stringtokenzier를 사용하려고함
        // 배열을 길이 개념을 다시 확인해볼 수 있었음
        int result = 0;
//        System.out.println(Arrays.toString(sub));
//        System.out.println(sub.length);
        for (int i = 0; i <sub.length ; i++) {
            String[] add = sub[i].split("\\+"); //+를 기준으로 각각의 식을 나눈다
            int sum = 0;

            for(int j = 0; j < add.length; j++){
                sum += Integer.parseInt(add[j]);

            }
            if(i == 0){
                result += sum;
            }else{
                result -= sum;
            }

        }

        System.out.println(result);
    }
}