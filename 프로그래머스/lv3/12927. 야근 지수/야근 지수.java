// demi 야근 
// 야근 피로도 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
// N 시간 동안 피로도를 최소화하도록 일 할 예정
// 1시간동안 1 만큼 처리할 수 있다고 할 떄 퇴근까지 남은 N시간과 
// 각 일에 대한 작업량 work에 대해 야근 피로도 최소화 

// 모든 수를 낮게 만드는게 이득인가?
// 7 -> 1 3 3 -> 18
//  2, 2, 3 -> 4 + 4 + 9 => 17
//  모든 수를 가장 낮게 만드는게 이득 
//  배열을 순회하기에는 시간이 부족함
//  그럼 어떤 방법으러 해결해야하는가?
//  전부다 더하고 n을 빼고 수를 나눈다면?

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            overtime.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int max = (int)overtime.poll();
            if (max <= 0) break;
            overtime.offer(max - 1);
        }
        
        return sumPow(overtime);
    }
    
    long sumPow(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty()) {
            sum += Math.pow(works.poll(), 2);
        }
        return sum;
    }
}
    