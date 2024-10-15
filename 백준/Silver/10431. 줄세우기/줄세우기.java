import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 키 순 정렬
    // 이분 탐색이 답이다?
    // 앞 인덱스 += 총인덱스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());
            int total = 0;
            while(st.hasMoreTokens()){
                if(list.isEmpty()){
                    list.add(Integer.parseInt(st.nextToken()));
                }else{
                    int tail = Integer.parseInt(st.nextToken());
                    int startIdx = binarySerach(list, tail);
                    total += list.size() -startIdx;
                    list.add(startIdx, tail);
                }
            }
            sb.append(" " + total + "\n");
        }
        System.out.println(sb);
    }

    private static int binarySerach( LinkedList<Integer> list, int tail){
        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = start + (end - start)/2;
            if(list.get(mid) < tail){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

}