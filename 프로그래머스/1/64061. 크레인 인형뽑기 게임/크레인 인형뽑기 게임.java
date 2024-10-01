
import java.util.*;

class Solution {
    static final int moveDirect = -1;
    static Stack<Integer> stack = new Stack<>();
    static int[][] map;
    static int N;
    static int result;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        N = board.length;
        map = new int[N][N];
        
        for(int i = 0; i < N; i ++){
            int[] temp = board[i];
            for(int j = 0; j < N; j++){
                map[i][j] = temp[j];
            }
        }
        
    
        
        
        int moveSize = moves.length;
            
        for(int i = 0; i < moveSize; i++){
            move(moves[i] - 1);
        }
        return result;
    }
    
    
    static void move(int target){
        for(int i = 0; i < N; i ++){
            if(map[i][target] != 0){
              
               check(map[i][target]);
                map[i][target] = 0;
               break;
            }
        }
    }
    
    static void check(int number){
        if(stack.isEmpty()){
            stack.add(number);
        }else{
            if(stack.peek() == number){
                stack.pop();
                result += 2;
            }else{
                stack.add(number);
            }
        }
    }
}