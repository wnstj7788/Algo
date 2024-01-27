import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Time {
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

    }
    public static class TimeCul implements Comparator<Time> {
        @Override
        public int compare(Time o, Time o2) {
            if(o.end == o2.end){
                return Integer.compare(o.start, o2.start);
            }
            return o.end - o2.end;

        }

    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Time> pq = new PriorityQueue<>(new TimeCul());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Time(start, end));
        }

        int cnt= 0;
        int endTime = 0;
        while(!pq.isEmpty()){
            Time now = pq.poll();

            if(now.start >= endTime){
                endTime = now.end;
                cnt++;
            }



        }
        System.out.println(cnt);

    }
}