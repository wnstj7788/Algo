import java.util.*;
// 한 명의 선수를 제외하고 다 완주했어
// 완주하지 못 한 선수의 이름을 Return 


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
       HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) 
            map.put(player, map.getOrDefault(player, 0) + 1);
        
        for (String player : completion) 
            map.put(player, map.get(player) - 1);

            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }

    
        
        return answer;
    }
}