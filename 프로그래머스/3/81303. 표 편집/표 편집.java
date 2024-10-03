import java.util.*;

class Solution {
    static class Node{
        int pre;
        int next;
        public Node(int pre, int next){
            this.pre = pre;
            this.next = next;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> delNode = new Stack<>();
        boolean[] isDel = new boolean[n];
        Node[] node = new Node[n]; 
        for(int i = 0; i < n; i++){
            node[i] = new Node(i-1, i +1);
        }
        node[n-1].next = -1; // 마지막 node 처리
        
        int nowIndex = k;
        
        for(String c : cmd){
            char command = c.charAt(0);
            if(command == 'U'){
                int cnt = Integer.parseInt(c.substring(2));
                while(cnt-- > 0) nowIndex = node[nowIndex].pre;
            }else if(command == 'D'){
                int cnt = Integer.parseInt(c.substring(2)); 
                while(cnt-- > 0) nowIndex = node[nowIndex].next;
            }else if(command == 'C'){
                delNode.push(nowIndex);
                isDel[nowIndex] = true;
                if(node[nowIndex].pre != -1) node[node[nowIndex].pre].next = node[nowIndex].next;
                if(node[nowIndex].next != -1) node[node[nowIndex].next].pre = node[nowIndex].pre;
                nowIndex = (node[nowIndex].next == -1) ? node[nowIndex].pre : node[nowIndex].next;
            }else if(command == 'Z'){
                int undoIndex = delNode.pop();
                isDel[undoIndex] = false;
                if(node[undoIndex].pre != -1) node[node[undoIndex].pre].next = undoIndex;
                if(node[undoIndex].next != -1) node[node[undoIndex].next].pre = undoIndex;
                
            }
        }
        
        // 결과 빌드
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isDel[i]) result.append('X');
            else result.append('O');
        }
        
        return result.toString();
    }
}