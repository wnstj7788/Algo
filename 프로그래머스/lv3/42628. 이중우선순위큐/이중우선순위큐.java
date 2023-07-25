import java.util.*;

public class Solution {
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public int[] solution(String[] operations) {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            char command = tokens[0].charAt(0);
            int num = Integer.parseInt(tokens[1]);

            if (command == 'I') {
                push(num);
            } else if (command == 'D') {
                if (num == 1) {
                    maxPop();
                } else if(num == -1) {
                    minPop();
                }
            }
        }

        int[] answer = new int[2];
        if (!max.isEmpty()) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }

        return answer;
    }

    public void push(int num) {
        max.add(num);
        min.add(num);
    }

    public void maxPop() {
        if (!max.isEmpty()) {
            int num = max.poll();
     
            min.remove(num);
        }
    }

    public void minPop() {
        if (!min.isEmpty()) {
            int num = min.poll();
         
            max.remove(num);
        }
    }
}