class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min =  1;
        int max = 200000000;
        
        while(min <= max){
            int mid = (min + max) / 2 ;
            // 넘어갈 수 있다면 
            if(isPossible(stones, k, mid)){
                min = mid +1 ;
                answer = Math.max(answer, mid);
            }else{
                // 못 넘어간다면 
                max = mid - 1;
            }
            
        }
        return answer;
    }
    
    public static boolean isPossible(int[] stones, int k, int frineds){
        int jump = 0;
        for(int stone : stones){
            if(stone - frineds < 0){
                jump++;
            }else{
                jump = 0;
            }
            if(jump == k){
                return false;
            }
        }
        return true;
    }
}