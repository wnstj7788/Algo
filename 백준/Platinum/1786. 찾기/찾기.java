import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] makeTable(String p){
        int plen = p.length();
        int[] table = new int[plen];

        int j = 0;

        for (int i = 1; i < plen; i++) {
            // a b a c
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                // 문자열 매칭 시작
                // 연속 일치 하지 않으면 j 값을 돌려주어 다시 매칭 시작
                j = table[j -1];
            }
            if(p.charAt(i) == p.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }

    public static void KMP(String str, String pattern) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int[] table = makeTable(pattern);
        int sLen = str.length();
        int pLen = pattern.length();

        int idx = 0; // 현재 대응되는 글자 수
        for (int i = 0; i < sLen; i++) {
            // idx번째 글자와 짚더미의 해당 글자가 불일치할 경우
            // 현재 대응된 글자의 수를 table[idx - 1]번으로 줄임
            while (idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            // 글자가 대응될 경우
            if (str.charAt(i) == pattern.charAt(idx)) {
                if (idx == pLen - 1) {
                    cnt++;
                    // parent 문자열과 pattern 문자열이 일치하기 시작한 시점을 출력
                    sb.append(i - idx + 1 + "\n");
                    idx = table[idx];
                }
                else {
                    idx++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        KMP(s1, s2);
    }
}