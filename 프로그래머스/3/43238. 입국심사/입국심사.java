class Solution {

    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 최소 시간: 1분 (모든 심사관이 1분일 때)
        long left = 1;
        
        // 최대 시간: 가장 오래 걸리는 심사관이 n명을 모두 처리할 때
        long right = (long) n * getMax(times);
        
        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2; // 중간 시간
            
            // mid 시간 동안 몇 명을 처리할 수 있는지 계산
            long total = getTotalPeople(times, mid);
            
            if (total >= n) {
                // mid 시간 동안 n명을 처리할 수 있으면, 시간을 줄여서 더 작은 답을 찾음
                answer = mid;
                right = mid - 1;
            } else {
                // 처리할 수 있는 사람 수가 부족하면, 시간을 늘려야 함
                left = mid + 1;
            }
        }
        
        return answer;
    }

    // 주어진 시간 동안 몇 명을 처리할 수 있는지 계산하는 메서드
    public long getTotalPeople(int[] times, long time) {
        long total = 0;
        for (int t : times) {
            total += time / t;
        }
        return total;
    }

    // 배열에서 가장 큰 값을 반환하는 메서드
    public int getMax(int[] times) {
        int max = times[0];
        for (int t : times) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }
}
