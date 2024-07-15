import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 
public class Solution {
 
    private static Node nodes[];
    private static boolean visited[];
    private static int cnt = 0;

 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TestCase = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= TestCase; t++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            nodes = new Node[V + 1];

            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node(i);
            }
            visited = new boolean[V +1];
            //making tree

            for(int i = 0; i < E; i++){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if(nodes[parent].left == 0){
                        nodes[parent].left = child;
                }else{
                    nodes[parent].right = child;
                }

                nodes[child].pre = parent;
            }  

            int commonParent = findParent(one, two);
            findSubTreeCnt(nodes[commonParent]);

            sb.append("#" + t).append(" " + commonParent + " ").append(cnt);
            sb.append("\n");



        }
        System.out.println(sb.toString());
      
    }

    private static int findParent(int one, int two){
       while(true){
            if(one != 1){
                int parent = nodes[one].pre;
                if(visited[parent]){
                   
                    return parent;
                }
                one = parent;
                visited[parent] = true;
            }

            if(two != 1){
                int parent = nodes[two].pre;
                if(visited[parent]){
                    return parent;
                }
                two = parent;
                visited[parent] = true;

            }
       }

    }

    private static void findSubTreeCnt(Node node){
        cnt++;
        if(node.left != 0){
            findSubTreeCnt(nodes[node.left]);
        }
        if(node.right  != 0){
            findSubTreeCnt(nodes[node.right]);
        }

    }

    private static class Node{
        int data;
        int pre;
        int left;
        int right;

         Node(int data){
            this.data = data;
            this.left = 0;
            this.right =0;
            this.pre = 0;
        }
    }
 
 

}