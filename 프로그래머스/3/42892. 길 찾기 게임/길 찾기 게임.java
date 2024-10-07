import java.util.*;

class Solution {
    class Node {
        int x, y, index;
        Node left, right;
        
        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        
        // 노드들을 리스트에 저장하고 y값 내림차순, x값 오름차순으로 정렬
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        nodes.sort((a, b) -> b.y == a.y ? a.x - b.x : b.y - a.y);
        
        // 루트를 기반으로 트리 생성
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }
        
        // 전위 순회
        preorder(root);
        // 후위 순회
        postorder(root);
        
        // 결과를 배열로 반환
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }

    // 이진 트리에 노드를 삽입하는 함수
    public void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    // 전위 순회
    public void preorder(Node node) {
        if (node == null) return;
        preorderList.add(node.index);
        preorder(node.left);
        preorder(node.right);
    }

    // 후위 순회
    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.index);
    }
}
