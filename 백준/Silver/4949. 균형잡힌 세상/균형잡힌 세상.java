import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			String str = bf.readLine();
			if(str.equals("."))
				break;
			Stack<Character> s = new Stack<Character>();
			String result = "";
			boolean flag = true;
			for(int i=0; i<str.length(); i++) {
				
				/* 여는괄호 '(' 나 '[' 는 스택에 넣어준다. */
				if(str.charAt(i) == '(')
					s.push('(');
				
				else if(str.charAt(i) == '[')
					s.push('[');
				
				/* 닫는괄호 ')' 나 ']' 는 스택이 비어있거나 여는괄호와 짝이 안맞는경우 -> 탈출한다. */
				/* 스택이 비어있는경우 -> 입력이 ))] 와 같은경우, */
				/* 짝이 안맞는경우 -> (([) 와 같은 경우, */
				else if(str.charAt(i) == ')') {
					if(s.isEmpty() || s.peek() != '(') {
						flag = false;
						break;
					}
					s.pop();
				}
				else if(str.charAt(i) == ']') {
						if(s.isEmpty() || s.peek() != '[') {
							flag = false;
							break;
						}
						s.pop();
						
				}
			}
			
			// 스택이 비어있지 않으면 균형이 맞지 않는 경우
			if(!s.isEmpty())
				flag = false;
			result = (flag) ? "yes" : "no";
			System.out.println(result);
			
		}
		bf.close();
	}

}