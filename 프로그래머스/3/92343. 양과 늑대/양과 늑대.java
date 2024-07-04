class Solution {

    int[] copyInfo;
    int[][] copyEdges;
    int maxSheepCnt = 0;
    
    int SHEEP = 0;
    int WOLF = 1;

    public int solution(int[] info, int[][] edges) {
        copyInfo = info; // 총 길이
        copyEdges = edges;
        boolean[] visited = new boolean[info.length];
        dfs(0, visited, 0, 0);

        return maxSheepCnt;
    }

    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true; // 방문 노드 체크
        // if (gInfo[idx] == 0)
        if (copyInfo[idx] == SHEEP) { // 양이라면 
            sheepCnt++;
            maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);
            // if (sheepCnt > maxSheepCnt) {
            //     maxSheepCnt = sheepCnt;
            // }
        } else { // 늑대라면
            wolfCnt++;
        }

        if (sheepCnt <= wolfCnt) { // 늑대가 양보다 같거나 많으면 종료
            return;
        }

        for (int[] edge : copyEdges) {
            if (visited[edge[0]] && !visited[edge[1]]) { // 부모 노드는 방문했고, 자식 노드는 방문하지 않았을 때 
            	boolean[] nextVisited = deepCopyVisitedArray(visited);
                
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }
    }
    
    public boolean[] deepCopyVisitedArray(boolean array[]){
        boolean[] copyVisitedArray = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                copyVisitedArray[i] = array[i];
        }
        return copyVisitedArray;
    }
}