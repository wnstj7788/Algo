import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// PUSH X -> X를 스택에 넣는 연산
// POP -> 스택 가장 위에 있는 수를  뺴고 출력 없으면 -1
// SIZE => 사이즈 출력
// empty -> 스택 비어있으면 1 아니면 0
// top => 가장 위에 있는 수 출력 없으면 -1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            }else if(command.equals("top")){
                if(!stack.empty()){
                    sb.append(stack.peek() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }else if(command.equals("pop")){
                if(!stack.empty()){
                    sb.append(stack.pop() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }

            }else if(command.equals("size")){
                sb.append(stack.size() + "\n");

            }else if(command.equals("empty")){
                if(!stack.empty()){
                    sb.append(0 + "\n");
                }else{
                    sb.append(1 + "\n");
                }

            }
        }

        System.out.println(sb.toString());

    }
}