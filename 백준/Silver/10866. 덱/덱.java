import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			int  x= 0;
			if(command.equals("push_front")) {
				x = Integer.parseInt(st.nextToken());
				dq.addFirst(x);
	
			}else if(command.equals("push_back")) {
				x = Integer.parseInt(st.nextToken());
				dq.addLast(x);
				
			}else if(command.equals("pop_front")) {
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				}else {
					sb.append(dq.pollFirst() + "\n");
				}
				
			}else if(command.equals("pop_back")) {
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				}else {
					sb.append(dq.pollLast() + "\n");
				}
				
			}else if(command.equals("size")) {
				sb.append(dq.size() + "\n");
				
			}else if(command.equals("empty")) {
				if(!dq.isEmpty()) {
					sb.append(0+ "\n");
				}else {
					sb.append(1 + "\n");
				}
				
			}else if(command.equals("front")) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekFirst() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				
			}else if(command.equals("back")) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				
				
			}
		}
		
		System.out.println(sb.toString());
	}

}