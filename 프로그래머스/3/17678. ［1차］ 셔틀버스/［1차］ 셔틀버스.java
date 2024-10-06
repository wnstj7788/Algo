import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
      
        Arrays.sort(timetable);
        
        // Step 2: Convert timetable to minutes
        List<Integer> crewArrivalTimes = new ArrayList<>();
        for (String time : timetable) {
            int hours = Integer.parseInt(time.split(":")[0]);
            int minutes = Integer.parseInt(time.split(":")[1]);
            crewArrivalTimes.add(hours * 60 + minutes); 
        }
        
        int shuttleTime = 9 * 60; 
        int conArrivalTime = 0;
        int crewIndex = 0; 
        
      
        for (int i = 0; i < n; i++) {
            int currentShuttleTime = shuttleTime + i * t; 
            int passengersOnBoard = 0; 
            
          
            while (passengersOnBoard < m && crewIndex < crewArrivalTimes.size() && crewArrivalTimes.get(crewIndex) <= currentShuttleTime) {
                passengersOnBoard++;
                crewIndex++;
            }
            
           
            if (i == n - 1) {
                if (passengersOnBoard < m) {
                  
                    conArrivalTime = currentShuttleTime;
                } else {
                   
                    conArrivalTime = crewArrivalTimes.get(crewIndex - 1) - 1;
                }
            }
        }
        
       
        int hour = conArrivalTime / 60;
        int minute = conArrivalTime % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}
