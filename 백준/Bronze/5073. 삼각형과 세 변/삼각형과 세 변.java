import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            if(one == 0){
                break;
            }

            if(!valid(one,two,three)){
                sb.append("Invalid" + "\n");
            }else{
                int max = Integer.MIN_VALUE;
                int list[] = new int[1001];
                list[one] ++;
                if(max < list[one])
                    max = list[one];

                list[two] ++;
                if(max < list[two])
                    max = list[two];

                list[three] ++;
                if(max < list[three])
                    max = list[three];

                if(max == 1){
                    sb.append("Scalene" + "\n");
                } else if (max == 2) {
                    sb.append("Isosceles" + "\n");
                }else{
                    sb.append("Equilateral" + "\n");
                }
            }



        }

        System.out.println(sb.toString());

    }

    private static boolean valid(int one, int two, int three){
        int map[] = new int[3];
        map[0] = one;
        map[1] = two;
        map[2] = three;

        Arrays.sort(map);

        if(map[2] < map[1] + map[0]){
            return true;
        }else
            return false;
    }
}