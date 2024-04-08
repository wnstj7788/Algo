import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        // 0 1 3 5 6
        // 0 번은 5번 인용
        // 1번의 4번 이용 
        // 3은 3번 인용 안 인용 2번  
        
		
		for(int i = 0; i < citations.length; i++) {
			int h = citations.length - i; // 인용된 논문의 수
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
        
        return answer;
    }
}