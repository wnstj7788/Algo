// import java.util.*;

// class Solution {
    
//     static Queue<String> chcheQueue = new LinkedList<String>(); 
//     public int solution(int cacheSize, String[] cities) {
//         int answer = 0;
//         if(cacheSize == 0){
//             return cities.length * 5;
//         }
        
//         for(int i = 0; i < cacheSize; i++){
//             String now = cities[i].toUpperCase();
//             chcheQueue.add(now);
//             answer += 5;
//         }
        
//         for(int i = cacheSize ; i < cities.length; i ++){
//             String targetCity = cities[i].toUpperCase();
//             answer += cache(targetCity, cacheSize);
//         }
        
        
        
//         return answer;
//     }
    
//     public static int cache(String targetCity, int cacheSize){
//         for(int i = 0; i < cacheSize; i ++ ){
//             String now = chcheQueue.poll();
//             if(targetCity.equals(now)){
//                 chcheQueue.add(now);
//                 return 1;
//             }
//             chcheQueue.add(now);
//         }
//         //없는 경우 첫 번째 녀석 뺴고 현재 도시 넣어주기 
//         chcheQueue.poll();
//         chcheQueue.add(targetCity);
//         return 5;
        
        
//     } 
// }




import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length*5;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String s = cities[i].toUpperCase();
            if(cache.remove(s)){
                answer += 1;
                cache.add(s);
            }else{
                answer += 5;
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                cache.add(s);
            }
        }
        return answer;
    }
}