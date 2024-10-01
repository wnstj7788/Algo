import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();  // 결과를 저장할 Set (중복 제거 위해 Set 사용)

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possibleBans = new ArrayList<>();  // 각 banned_id에 대해 매핑 가능한 user_id 리스트 저장
        
        // 1. banned_id 별로 매칭 가능한 user_id 리스트 만들기
        for (String banId : banned_id) {
            List<String> matchedUsers = new ArrayList<>();
            for (String userId : user_id) {
                if (isMatching(userId, banId)) {
                    matchedUsers.add(userId);  // 패턴이 일치하는 user_id를 리스트에 추가
                }
            }
            possibleBans.add(matchedUsers);
        }

        // 2. DFS로 가능한 조합 찾기
        findCombinations(possibleBans, new HashSet<>(), 0);

        // 3. 결과의 경우의 수 반환
        return result.size();
    }

    // userId와 banId가 매칭되는지 확인
    private boolean isMatching(String userId, String banId) {
        if (userId.length() != banId.length()) {
            return false;
        }
        for (int i = 0; i < userId.length(); i++) {
            if (banId.charAt(i) != '*' && userId.charAt(i) != banId.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // DFS로 가능한 조합을 찾음
    private void findCombinations(List<List<String>> possibleBans, Set<String> currentSet, int index) {
        // 모든 banned_id에 대해 매칭이 완료된 경우
        if (index == possibleBans.size()) {
            result.add(new HashSet<>(currentSet));  // 현재의 조합을 결과에 추가 (중복 허용 안함)
            return;
        }

        // 현재 banned_id에 해당하는 가능한 user_id 중 하나를 선택
        for (String user : possibleBans.get(index)) {
            if (!currentSet.contains(user)) {  // 이미 선택한 user는 다시 선택하지 않음
                currentSet.add(user);
                findCombinations(possibleBans, currentSet, index + 1);
                currentSet.remove(user);  // 백트래킹
            }
        }
    }
}
