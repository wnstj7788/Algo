import java.util.*;

class Solution {
    static class Node {
        int prev, next;

        public Node(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];  // 각 노드의 prev, next 저장
        Stack<Integer> removed = new Stack<>();  // 삭제된 행 저장
        boolean[] isDeleted = new boolean[n];  // 삭제 여부 저장
        
        // 이중 연결 리스트 초기화
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i - 1, i + 1);
        }
        nodes[n - 1].next = -1;  // 마지막 노드는 next가 없음

        int current = k;  // 현재 선택된 행

        for (String command : cmd) {
            char c = command.charAt(0);

            if (c == 'U') {
                int move = Integer.parseInt(command.substring(2));
                while (move-- > 0) current = nodes[current].prev;

            } else if (c == 'D') {
                int move = Integer.parseInt(command.substring(2));
                while (move-- > 0) current = nodes[current].next;

            } else if (c == 'C') {
                removed.push(current);  // 삭제된 행을 스택에 저장
                isDeleted[current] = true;

                // 현재 노드 삭제
                if (nodes[current].prev != -1) nodes[nodes[current].prev].next = nodes[current].next;
                if (nodes[current].next != -1) nodes[nodes[current].next].prev = nodes[current].prev;

                // 다음 노드로 이동 (마지막 행이면 이전 노드로)
                current = (nodes[current].next != -1) ? nodes[current].next : nodes[current].prev;

            } else if (c == 'Z') {
                int restored = removed.pop();  // 최근 삭제된 행 복구
                isDeleted[restored] = false;

                // 복구된 노드 다시 연결
                if (nodes[restored].prev != -1) nodes[nodes[restored].prev].next = restored;
                if (nodes[restored].next != -1) nodes[nodes[restored].next].prev = restored;
            }
        }

        // 결과 빌드
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isDeleted[i]) result.append('X');
            else result.append('O');
        }
        
        return result.toString();
    }
}
