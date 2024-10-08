class Solution {
    public int solution(int[] a) {
        // 풍선이 1개 이하인 경우, 바로 리턴
        if (a.length <= 1) return a.length;
        
        int n = a.length;
        int answer = 0;

        // 각 풍선에 대해 왼쪽에서의 최솟값, 오른쪽에서의 최솟값을 구합니다.
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        // 초기 값 설정
        leftMin[0] = a[0];
        rightMin[n - 1] = a[n - 1];
        
        // 왼쪽에서 가장 작은 값 추적
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        // 오른쪽에서 가장 작은 값 추적
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        // 각 풍선이 최후까지 남을 수 있는지 확인
        for (int i = 0; i < n; i++) {
            // 현재 풍선이 좌우 최솟값보다 작은 경우에만 남을 수 있음
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}