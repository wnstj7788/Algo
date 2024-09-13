class Solution {
    public int[] solution(int n, int s) {
  
        int mok = s/n;
        int r = s%n;
        if(mok == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        for(int i = answer.length-1; i >= 0;i--){            
            answer[i] = mok;
            if(r > 0){
                answer[i]++;
                r--;
            }
        }

        return answer;
    }
    
}