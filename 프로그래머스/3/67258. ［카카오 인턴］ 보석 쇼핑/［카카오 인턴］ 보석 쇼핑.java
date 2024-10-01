import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 모든 보석 종류를 Set으로 구함
        Set<String> allGems = new HashSet<>(Arrays.asList(gems));
        int totalGemCount = allGems.size();

        // 투 포인터 알고리즘에 사용할 변수들
        Map<String, Integer> gemCountMap = new HashMap<>();
        int start = 0, end = 0;
        int minStart = 0, minLength = Integer.MAX_VALUE;

        while (end < gems.length) {
            // 현재 보석을 map에 추가하여 개수 세기
            gemCountMap.put(gems[end], gemCountMap.getOrDefault(gems[end], 0) + 1);
            end++;

            // 모든 보석을 포함하고 있다면 start를 오른쪽으로 이동하면서 최소 구간을 찾기
            while (gemCountMap.size() == totalGemCount) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }

                // start 위치의 보석 제거 또는 개수 감소
                gemCountMap.put(gems[start], gemCountMap.get(gems[start]) - 1);
                if (gemCountMap.get(gems[start]) == 0) {
                    gemCountMap.remove(gems[start]);
                }
                start++;
            }
        }

        // 1-based 인덱스 반환
        return new int[]{minStart + 1, minStart + minLength};
    }
}
