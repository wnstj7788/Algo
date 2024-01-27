import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Solution {
    static LinkedList<Integer> list;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for(int TC=1; TC<=10; TC++) {
            list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int command = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<command; i++) {
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                cur(cmd, x);
            }

            sb.append("#"+TC);
            for(int i =0; i<10; i++) {
                sb.append(" " + list.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    private static void cur(String cmd, int x) {
        int y;

        if(cmd.equals("I")){
            y = Integer.parseInt(st.nextToken());
            for(int i=0, insertIdx = x; i<y; i++, insertIdx++) {
                list.add(insertIdx, Integer.parseInt(st.nextToken()));
            }
        } else if (cmd.equals("D")) {
            y = Integer.parseInt(st.nextToken());
            for(int i=0; i<y; i++)
                list.remove(x);

        }else{
            for(int i=0; i<x; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

        }

    }
}