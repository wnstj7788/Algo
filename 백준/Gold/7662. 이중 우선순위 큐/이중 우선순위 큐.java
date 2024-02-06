import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // initialize treemap<value, count>
        TreeMap<Integer, Integer> tm = new TreeMap<>(); // 작은 값이 앞에, 큰 값에 뒤에 저장됨
        //  red-black tree의 방법으로 삽입 시에 바로 정렬이 되는 자료구조
        //  그래서 삽입 시에 O(log N)의 시간복잡도가 소요
       // 또한 lastKey()와 firstKey()를 통해 값을 가져오는 연산도 O(log N)이라는 시간복잡도 밖에 소요되지 않는다

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            tm.clear();
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                char func = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                // function
                // insert
                if(func == 'I'){
                    // 같은 값이 삽입될 경우, count+1
                    /*
                    tm.getOrDefault(num, 0): TreeMap에서 주어진 key(num)에 해당하는 값(value)을 가져오는데, 
                    만약 key가 존재하지 않으면 기본값으로 0을 사용합니다.+1: 가져온 값에 1을 더합니다.
                    따라서 전체적으로는 "만약 TreeMap에 이미 해당 key(num)가 존재하면 해당 key의 값을 1 증가시키고, 
                    존재하지 않으면 해당 key를 1로 설정하여 TreeMap에 추가한다"는 의미를 가지고 있습니다.
                     */
                    tm.put(num, tm.getOrDefault(num, 0)+1);
                }
                else{
                    if(tm.isEmpty()) continue;
                    int value, cnt;
                    // delete max
                    if(num == 1){
                        value = tm.lastKey();
                    }
                    //delete min
                    else{
                        value = tm.firstKey();
                    }
                    cnt = tm.get(value);
                    // delete if count == 1
                    tm.remove(value);
                    if(cnt > 1) tm.put(value, cnt-1);
                }
            }
            // print empty
            if(tm.isEmpty()) sb.append("EMPTY\n");
                // print max, min
            else{
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}