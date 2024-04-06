import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 같은 포케몬 같은 번호 
        // 3번 포케몬 2마리
        // 1번 포캐몬 1마리 
        // 2번 포케몬 1마리 
        // 최데 포케몬 가질 수 있는 수는 2가지 
        // 해시 사이즈를 만들고 
        // 해시의 key 길이 에서 N/2 로나눈게 더 크다면 냠냠
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int len = nums.length;
        
        for(int i = 0; i < len; i++){
            int temp = nums[i];
            hm.put(temp,temp);
        }
        
        if(len / 2 < hm.size()){
            return len/2;
        }else{
            return hm.size();
        }
        
    }
}