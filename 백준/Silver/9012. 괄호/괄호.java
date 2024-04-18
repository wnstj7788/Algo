/*
 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 
 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 
 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
 */
/*
 * 
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
 */
/*
 * NO
NO
YES
NO
YES
NO
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String VPS = br.readLine();
            char[] vpsArr = VPS.toCharArray();
            Stack<Character> st = new Stack<>();

            boolean isValid = true;

            for (int j = 0; j < vpsArr.length; j++) {
                if (vpsArr[j] == '(') {
                    st.push(vpsArr[j]);
                } else if (vpsArr[j] == ')') {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && st.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }    
}