import java.util.*;
import java.io.*;

/*
 String 형으로 문자에 a-z 각각의 알파벳이 몇번 등장하는지 반환
 step1. a - z 배열 선언
 step2. 각각의 유니코드 값 도출 해당 인덱스 + 1
 stop3. 반환
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] st = br.readLine().toCharArray();

        int result[] = new int[26];


        for (char c : st) {
           // int index = c - 97; //  a
            int index = c -'a';
            result[index]++;
        }

        for (int now : result){
            System.out.print(now + " ");
        }


    }
}