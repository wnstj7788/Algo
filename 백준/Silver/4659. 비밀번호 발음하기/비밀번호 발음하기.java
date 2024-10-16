import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) break;

            sb.append("<").append(password).append("> ");

            if (isAcceptable(password, vowels)) {
                sb.append("is acceptable.\n");
            } else {
                sb.append("is not acceptable.\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 패스워드가 조건을 만족하는지 확인하는 함수
    public static boolean isAcceptable(String password, Set<Character> vowels) {
        boolean hasVowel = false; // 모음 포함 여부
        int consecutiveVowels = 0; // 연속된 모음 수
        int consecutiveConsonants = 0; // 연속된 자음 수
        char prevChar = ' '; // 이전 문자 저장

        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);

            // 모음 체크
            if (vowels.contains(currentChar)) {
                hasVowel = true;
                consecutiveVowels++;
                consecutiveConsonants = 0;
            } else {
                consecutiveConsonants++;
                consecutiveVowels = 0;
            }

            // 모음이 3개 연속이거나 자음이 3개 연속이면 false
            if (consecutiveVowels >= 3 || consecutiveConsonants >= 3) {
                return false;
            }

            // 같은 글자가 두 번 연속으로 오는지 확인 (ee, oo는 예외)
            if (i > 0 && prevChar == currentChar && !(prevChar == 'e' || prevChar == 'o')) {
                return false;
            }

            prevChar = currentChar;
        }

        // 모음이 하나도 포함되지 않았으면 false
        return hasVowel;
    }
}