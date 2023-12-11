import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        ArrayList<String> word = new ArrayList<>();
        
        word.add(words[0]);
        
        for(int i = 1; i < words.length; i ++){
            char lastChar = words[i -1].charAt(words[i -1].length() -1);
            char startChar = words[i].charAt(0);
         if(word.contains(words[i]) || lastChar != startChar){
                answer[0] = i % n +1;
                answer[1] = i / n + 1;
                return answer;
            }else{
                word.add(words[i]);
            }    
            
        }
        
        return answer;
    
    }
}