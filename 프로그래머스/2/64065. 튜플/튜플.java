import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        
        s= s.replace("{","");
        s=s.replace("},","-");
        s=s.replace("}}","");
        
        ArrayList<Integer> list = new ArrayList<>();
        
        String [] array = s.split("-"); // 배열에 한 번에 넣기 
        
        // array 정렬이 필요함 길이에 맞게 정렬 -> 2, 21, 213, 2134 => 2 1 3 4 답이 나옴 
        Arrays.sort(array, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(int i = 0; i < array.length; i++){
            String [] now = array[i].split(",");
            int size = now.length;
            for(int j = 0; j < size; j++){
                int nowNum = Integer.parseInt(now[j]);
                if(!list.contains(nowNum)){ // 해당 요소가 없다면 
                    list.add(nowNum);
                }
            }
     
        }
        
        int listSize = list.size();
        
        int answer[] = new int[listSize];
        
        for(int i = 0; i < listSize; i ++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}