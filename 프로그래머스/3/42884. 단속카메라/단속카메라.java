import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override 
            public int compare(int[] route1, int[] route2){
                return route1[1] - route2[1];
            }
        });
        
     
        int cam = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(cam < route[0]) {
                // -15지점에 하나 
                // -5 지점에 하나 
                cam = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
// 모든 차들을 모니터링할 수 있도록 최소 카메라 대수를 산정하는 것이 목표 
 // 차량 1 ~ 10,000 대 
// 입차, 출차 지점이 나와있음

// ---  입차 -----출차 
//                     - 입차 ----------- 출차
// -입차                   - 출차   
//                                         입차 ----출차

// 가장 먼저 들어오는 작은 수를 기준으로 입차를 함 
// -15