import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> s = new Stack<Character>();
        while(true) {
            s.clear();
            StringBuffer text = new StringBuffer();
            text.append(br.readLine());
            if(text.charAt(text.length()-1) != '.') {
                continue;
            }
            //"."하나만 들어오면 종료
            if(text.toString().equals(".")) {
                break;
            }

            boolean flag = true;
            for(int i=0 ; i<text.length() ;i++) {
                if(text.charAt(i) == '(' || text.charAt(i) == '[') {
                    s.push(text.charAt(i));
                }else if(text.charAt(i) == ')') {
                    if(s.size()==0 || s.pop() != '(') {
                        flag =false;
                        break;
                    }
                }else if(text.charAt(i)==']') {
                    if(s.size()==0 || s.pop() != '[') {
                        flag =false;
                        break;
                    }
                }
            }
            if(!s.isEmpty())
                flag = false;
            if(flag == true)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        br.close();
        bw.flush();
        bw.close();
	}

}