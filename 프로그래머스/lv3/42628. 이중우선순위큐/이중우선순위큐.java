import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        TreeMap<Integer, Integer> tree = new TreeMap<>();

        int num = 0;
        int cnt = 0;

        for (String operation : operations) {
            String[] temp = operation.split(" ");
            char command = temp[0].charAt(0);
            num = Integer.parseInt(temp[1]);

            if (command == 'I') {
                tree.put(num,cnt++);
            } else {
                if (num == 1) {
                    tree.pollLastEntry(); // 최대값 제거
                } else if (num == -1) {
                    tree.pollFirstEntry(); // 최소값 제거
                }
            }
        }
        
        int min = 0;
        int max = 0;

        if (!tree.isEmpty()) {
            max = tree.firstKey(); // 최대값
            min = tree.lastKey(); // 최소값
        }
        
        int answer[] = {min, max};

        return answer;
    }
}




