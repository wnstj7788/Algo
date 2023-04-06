import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Integer> myList = new ArrayList<>();
        String [] arr = s.split(" ");
        
        for(int i = 0; i <  arr.length; i++){
            myList.add(Integer.parseInt(arr[i]));
            
        }
        answer = Collections.min(myList) + " " + Collections.max(myList);
        
        return answer;
    }
}