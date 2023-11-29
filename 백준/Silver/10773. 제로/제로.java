import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i <len ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        int size = stack.size();
        int result = 0;
        for (int i = 0; i <size ; i++) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}