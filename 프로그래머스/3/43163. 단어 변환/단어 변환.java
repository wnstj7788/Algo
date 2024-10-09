import java.util.*;

class Solution {
    
    static class Word{
        String word;
        int cnt;
        
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0; 
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        boolean isVisited[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            String nowWord = now.word;
            int cnt = now.cnt;
            if(nowWord.equals(target)){
                return cnt;
            }
            
            for(int i = 0 ; i < words.length; i++){
                if(!isVisited[i] && onlyOneDiff(nowWord, words[i])){
                    isVisited[i] = true;
                    q.add(new Word(words[i], cnt+1));
                }
            }
            
        }
        
        
        return answer;
    }
    
    private static boolean onlyOneDiff(String nowWord, String nextWord){
        int diffCnt = 0;
        
        for(int i =0 ; i < nowWord.length(); i++){
            if(nowWord.charAt(i) != nextWord.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt == 1 ? true : false;
    }
}