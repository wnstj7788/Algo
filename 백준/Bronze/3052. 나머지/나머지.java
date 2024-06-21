import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /*
     * 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
     * 1. 중복을 허용하지 않는다. (y / n) => Y(서로 다른 값) 
     * 2. 순서가 중요하다.  (y / n) => N (순서가 중요하지 않음, 크기가 중요함)
     * 3. 정렬이 되어 있어야 한다. (y / n) => N (정렬이 중요하지 않음, 크기가 중요함)
     * 
     * 단순 Set 자료로 해결이 가능하기에 HashSet을 통해 문제를 해결 가능함.
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(br.readLine()) % 42;
            set.add(temp);
        }
        System.out.println(set.size());
    }
    
}