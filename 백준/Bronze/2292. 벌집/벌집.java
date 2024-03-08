import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 1  1
    // 2  7   6
    // 3 19   12
    // 4 37   18
    // 5 61   24
    // 6 91   30



    // 13
    // 이전 값 < 다음 값 사이 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int num = 6;

        int target = Integer.parseInt(br.readLine());
        int cnt = 1;
        int lastNumber = 1;
        int nextNumber = 1;


        while (true){

            if(target == 1){
                System.out.println(1);
                break;
            }

            nextNumber = lastNumber + (num * cnt);
           // System.out.println("nextNumer : " + nextNumber);
            // 6

            // 1 6
            if(lastNumber <= target && target <= nextNumber){
                System.out.println(cnt + 1);
                break;
            }

            cnt++;
            lastNumber = nextNumber;
         //   System.out.println("number Change cnt  : " + cnt + "nexNumber : "  + nextNumber );


        }

    }


}