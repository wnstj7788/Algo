import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class TimeComparator implements Comparator<Time> {
        @Override
        public int compare(Time t1, Time t2) {
            // 종료 시간이 같으면 시작 시간이 빠른 순으로 정렬
            if (t1.end == t2.end) {
                return Integer.compare(t1.start, t2.start);
            }
            return Integer.compare(t1.end, t2.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        ArrayList<Time> meetings = new ArrayList<>();

        // 회의 입력 받기
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Time(start, end));
        }

        // 회의 시간을 끝나는 시간을 기준으로 정렬
        Collections.sort(meetings, new TimeComparator());

        int endTime = 0; // 현재 선택된 회의의 끝나는 시간
        int count = 0;   // 선택한 회의의 수

        for (Time meeting : meetings) {
            if (meeting.start >= endTime) {
                endTime = meeting.end;
                count++;
            }
        }

        System.out.println(count);
    }
}