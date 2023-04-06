import java.util.*;
class Solution
{
    static boolean isSelected[];
    static int permResult[];
    static int result = Integer.MAX_VALUE;
    public int solution(int []A, int []B)
    {
        int answer = 0;
    
    
       //1. B의 길이를 구해서 B를 Perm 진행 
        
        // int size = B.length;
        // isSelected = new boolean[size];
        // permResult = new int[size];
        // perm(0, B, A, size);
        
        Arrays.sort(A);
        Arrays.sort(B);
        int[] B_RE  = new int[A.length];
        
        for (int i = A.length - 1, j = 0; i >= 0; i--, j++) {
            B_RE[j] = B[i];
        }
        
        int sum = 0;
        for(int i = 0; i <  A.length ; i++){
            sum += A[i] * B_RE[i];
        }
        
        
        //2. 곱셈 연산을 통해 최소 값 갱신 
        answer = sum;
        
        
        
        
        // 시간 초과가 난다? -> 이걸 큰 수 곱하기 작은 수로 정렬해서 첫번재 값을 나오게 한다면?
        
        
        
        
        return answer;
    }
    
    
    static void perm(int idx, int[] B , int[] A, int size){
        if(idx ==size){
            // System.out.println(Arrays.toString(permResult));
            
             cal(permResult , B);
            return;
        }
        
        for(int i = 0; i <  size; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            permResult[idx] = A[i];
            perm(idx + 1, B ,  A , size);
            isSelected[i] = false;
            
        }
        
        
    }
    
    
    static void cal(int[] permResult , int[] B ){
        int sum = 0;
        for(int i =0; i < B.length; i++){
            sum += permResult[i] * B[i];
        }
        if(result > sum){
            result = sum;
        }
        
        
        
    }
}