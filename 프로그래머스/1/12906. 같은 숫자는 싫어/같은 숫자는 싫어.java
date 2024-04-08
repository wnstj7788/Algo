import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                q.add(arr[i]);
            }
        }
        
        int[] result = new int[q.size()];
        int idx = 0;
        
        while (!q.isEmpty()) {
            result[idx++] = q.poll();
        }
        
        return result;
    }
}
