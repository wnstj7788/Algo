import java.util.*;

public class Solution {
    static class Runner implements Comparable<Runner>{
        int posi;
        int en;
        
        public Runner(int posi, int en){
            this.posi = posi;
            this.en = en;
        }
        
        @Override
        public int compareTo(Runner other) {
            return Integer.compare(this.en, other.en);
        }
        
    }
    
    public int solution(int n) {
        int ans = 1;
        int divCount = 0;
        while(true){
            if(n <= 2) break;
            
            if(n%2 != 0) {
                n = n - 1;
                divCount += 1;
            }else {
                n = n / 2;
            }
            
        }
        ans = 1 + divCount;
        return ans;
    }

//         return bfs(n);
//     }
    
    
    public static int bfs(int n){
        PriorityQueue<Runner> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[100000001];
        Runner runner = new Runner(0,0);
        pq.add(runner);
        
        visited[0] = true;
        
        while(!pq.isEmpty()){
            Runner now = pq.poll();
            if(now.posi == n){
                return now.en;
            }
            int nowPosi = now.posi;
            int nowEn = now.en;
            
            if(!visited[nowPosi + 1] && nowPosi + 1 <= n ){
                pq.add(new Runner(nowPosi + 1, nowEn + 1));
            }
            
            if(nowPosi * 2 != 0 && !visited[nowPosi * 2] && nowPosi <= n){
                pq.add(new Runner(nowPosi*2, nowEn));
            }
        }
        return -1;
    }
}
