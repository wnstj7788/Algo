import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length]; // 배열 사이즈 
        StringBuilder sb;

        for(int i=0; i<s.length; i++) { // 테스트 케이스 하나씩 
            String str = s[i]; 
            Stack<Character> stack = new Stack<>();
            int cnt = 0; //110 사이즈 

            for(int j=0; j<str.length(); j++) { // 4, 9 , 10 
                char z = str.charAt(j); // 첫번쨰 인덱스 
            
                if(stack.size()>=2) {
                    char y = stack.pop(); // 1
                    char x = stack.pop(); // 1
                                        // z == 1
                    if(x=='1' && y=='1' && z=='0') {
                        cnt++;
                    } else {
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                } else {
                    stack.push(z); // s = 1 1 1 0
                }
            }
        
            int idx = stack.size(); // 1
            boolean flag = false;
            sb = new StringBuilder();
            while(!stack.isEmpty()) {
                if(!flag && stack.peek()=='1') {
                    idx--; // 0
                }

                if(!flag && stack.peek()=='0') {
                    flag = true;
                }

                sb.insert(0, stack.pop()); //sb = 1
             
            }

            if(cnt>0) {
                while(cnt>0) {
                    sb.insert(idx, "110");
                    idx += 3;
                    cnt--;
                }
                answer[i] = sb.toString();
            } else {
                answer[i] = s[i]; // 1 
            }
        }
        return answer;
    }
}