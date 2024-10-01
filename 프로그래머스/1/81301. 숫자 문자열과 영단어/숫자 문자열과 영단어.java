class Solution {
    static final int Numbers = 10;
    public int solution(String s) {
        int answer = 0;
        
        String[] numEng = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i =0; i < Numbers; i++){
            s = s.replace(numEng[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}