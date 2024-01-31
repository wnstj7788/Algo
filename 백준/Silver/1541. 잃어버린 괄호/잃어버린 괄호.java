import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.MAX_VALUE;
        // String[] partition = br.readLine().split("-"); // -를 기준으로 자르기

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()){
            int value = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){

               value +=Integer.parseInt(st2.nextToken());
            }



            if(total == Integer.MAX_VALUE){
                total = value;
            } else {
                total -= value;
            }
        }

        System.out.println(total);




    }
}