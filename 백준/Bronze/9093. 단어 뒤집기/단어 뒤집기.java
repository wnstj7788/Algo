import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Character> stack;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < len; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                reverse(st.nextToken());
            }
            System.out.println(sb.toString());

        }
        
    }

    public static void reverse(String st){
        stack = new Stack<>();
        char[] charArr = st.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            stack.add(charArr[i]);
        }

        for (int i = 0; i < charArr.length; i++) {
            sb.append(stack.pop());
        }
        sb.append(" ");
        

    }
    
}