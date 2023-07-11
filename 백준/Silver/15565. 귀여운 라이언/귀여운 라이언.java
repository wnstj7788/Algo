import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main { 
    
    // 15565번 - 귀여운 라이언
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int[] doll=new int[Integer.parseInt(input[0])]; 
        int k=Integer.parseInt(input[1]);  
        ArrayList<Integer> lion=new ArrayList<Integer>();   
        
        input=br.readLine().split(" ");
        for(int i=0;i<doll.length;i++) {
            doll[i]=Integer.parseInt(input[i]);
            if(doll[i]==1) lion.add(i);    
        }
        
        if(lion.size()<k) { 
            System.out.println(-1);
            return;
        }
        

        int start=0,end=k-1;   
        int min=Integer.MAX_VALUE, cnt=0;
        while(true) {
            if(end==lion.size()) break;
            cnt=lion.get(end)-lion.get(start)+1;
            min=Math.min(min, cnt);
            
            start++;
            end++;
        }
        
        System.out.println(min);
    }
}