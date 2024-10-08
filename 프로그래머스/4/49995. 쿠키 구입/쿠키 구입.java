class Solution {
    public int solution(int[] cookie) {
        int maxCookies = 0;  // 한 명에게 줄 수 있는 최대 과자 수

        // m을 기준으로 왼쪽 구간과 오른쪽 구간을 나눕니다.
        for (int m = 0; m < cookie.length - 1; m++) {
            int leftSum = cookie[m];    // l부터 m까지의 합
            int rightSum = cookie[m + 1]; // m+1부터 r까지의 합
            int left = m;
            int right = m + 1;

            // 두 구간의 합이 같을 때까지 왼쪽과 오른쪽을 확장합니다.
            while (left >= 0 && right < cookie.length) {
                if (leftSum == rightSum) {
                    maxCookies = Math.max(maxCookies, leftSum);  // 더 큰 합으로 갱신
                }

                // 합이 같지 않으면, 어느 쪽이 더 작은지에 따라 해당 구간을 확장
                if (leftSum <= rightSum && left > 0) {
                    left--;  // 왼쪽을 확장
                    leftSum += cookie[left];
                } else if (rightSum < leftSum && right < cookie.length - 1) {
                    right++;  // 오른쪽을 확장
                    rightSum += cookie[right];
                } else {
                    break;  // 더 이상 확장할 수 없을 때
                }
            }
        }

        return maxCookies;
    }

    
}
