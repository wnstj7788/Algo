import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        // N 개의 숫자 
        // C 보다 작거나 같음 
        // 빈도 순 정렬 = 빈도 수가 같다면 먼저 나온게 앞에 있어야함 
        // 2 1 2 1 2 

        // 2 : 3
        // 1 : 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(map.containsKey(number)){
                int count = map.get(number) + 1;
                map.put(number, count);
            }else{
                map.put(number, 1);
            }
            

        }
        LinkedList<Integer> list = new LinkedList<>(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            
        });


        Iterator<Integer> iter = list.iterator();

        while(iter.hasNext()){
            Integer num = iter.next();
            for (int i = 0; i < map.get(num); i++) {
                sb.append(num + " ");
            }
        }

        System.out.println(sb.toString());

    }
    
}