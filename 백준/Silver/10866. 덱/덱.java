/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new LinkedList<Integer>();

        int len = Integer.parseInt(br.readLine());
        int number = 0;

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_back")){
                number = Integer.parseInt(st.nextToken());
                dq.addLast(number);
            }else if (command.equals("push_front")) {
                number = Integer.parseInt(st.nextToken());
                dq.addFirst(number);
            }else if (command.equals("pop_front")) {
                if(!dq.isEmpty()){
                    sb.append(dq.poll() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }

            }else if (command.equals("pop_back")){
                if(!dq.isEmpty()){
                    sb.append(dq.pollLast() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }

            }else if(command.equals("size")){
                sb.append(dq.size() + "\n");

            }else if (command.equals("empty")){
                if(!dq.isEmpty()){
                    sb.append(0 + "\n");
                }else{
                    sb.append(1 + "\n");
                }
            }else if (command.equals("front")) {
                if(!dq.isEmpty()){
                    sb.append(dq.peek() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
                
            }else if(command.equals("back")){
                if(!dq.isEmpty()){
                    sb.append(dq.peekLast() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }

            }

        }
        System.out.println(sb.toString());
    }
}