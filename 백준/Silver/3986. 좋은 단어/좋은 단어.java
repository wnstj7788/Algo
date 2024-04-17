import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        for (int j = 0; j < t; j++) {
            String s = br.readLine();
            if (s.length() % 2 == 1) continue; //문자열의 길이가 홀수이다는 것은 A 또는 B의 개수가 홀수이므로 좋은단어 X
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0)); //첫 단어는 스택에 push
            for (int i = 1; i < s.length(); i++) {
                if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty()) count++;
        }
        
        System.out.print(count);
    
    }
           
    
}