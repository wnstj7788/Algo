class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        //진수 전환
        // 10 -> k 진수
        //Integer.toStirng(n,k)
        // k진수 -> 10진수 
        // Integer.parseInt(n,k)
        
        //1. 현재 수를 k 진수로 변환하기
       
        String nowNum = Integer.toString(n,k);
        
        int i , j ;
        for(i = 0; i < nowNum.length(); i = j) {
            for(j = i + 1; j < nowNum.length() && nowNum.charAt(j) != '0'; j++);
            if(isprime(Long.parseLong(nowNum.substring(i,j))))
                answer++;
        }
        return answer;
    }
    
    public static  boolean isprime(long n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) 
                return false;
        return true;
    }
}