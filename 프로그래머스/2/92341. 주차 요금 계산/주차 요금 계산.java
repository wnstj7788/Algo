import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
      
        
        Map<String, Integer> park = new HashMap<>();
        Map<String, Integer> costs = new TreeMap<>(); // 오름차순 정렬 
        
        for(String temp : records){
            String[] record = temp.split(" ");
            // [05:30, 5961, IN]
            int startMin = getMin(record[0]);
            String carNum = record[1];
            String io = record[2];
            
            // 입차라면
            if(io.equals("IN")){
                park.put(carNum, startMin);
            }else{
                //출차라면
                if (!costs.containsKey(carNum)) {
                    costs.put(carNum, startMin - park.get(carNum));
                } else { // 한번 입출차한 기록이있다면 기존 시간에 새 시간 누적
                    costs.put(carNum, costs.get(carNum) + startMin - park.get(carNum));
                }
                park.remove(carNum);
            }
            
        }// for end
        
       // 안 나간 차들 계산 
        if (!park.isEmpty()) {
            for (String carNum : park.keySet()) {
                Integer cost = costs.get(carNum);
                cost = (cost == null) ? 0 : cost;
                costs.put(carNum, cost + (23 * 60 + 59) - park.get(carNum));
            }
        }
         
        List<Integer> answer = new ArrayList<>(costs.size());
        for (Integer c : costs.values()) {
            int basicTime = fees[0];
            int basicCharge = fees[1];
            int unitTime = fees[2];
            int unitCharge = fees[3];
 
            // 요금 = 기본요금 + ((min-기본시간) / 단위시간) * 단위요금
            if (c <= basicTime) {
                answer.add(basicCharge) ;
            } else {
                answer.add((int) (basicCharge + Math.ceil((double) (c - basicTime) / unitTime) * unitCharge));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public Integer getMin(String min){
        String time[] = min.split(":");
        return (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
    }
    
}