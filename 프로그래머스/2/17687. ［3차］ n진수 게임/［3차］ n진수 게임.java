class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        // step 1. 진수변환
        StringBuilder changeNum = new StringBuilder();

        // 무한히 반복되는 코드를 작성하고 미리 구해야할 t만큼의 길이를 구하면 멈추기 
        int i = 0;
        while (changeNum.length() < t * m) {
            changeNum.append(Integer.toString(i++, n));
        }

        // stop 2. 순서를 기반으로 정답 받기
        // 반복 범위 수정: t개의 숫자를 모두 구할 때까지 반복
        for (i = p - 1; answer.length() < t; i += m) {
            // 인덱스 조건 추가: i가 changeNum의 길이를 넘어가면 반복 종료
            if (i >= changeNum.length()) {
                break;
            }
            // 대문자 변환을 빌더에 직접 적용
            answer.append(Character.toUpperCase(changeNum.charAt(i)));
        }

        return answer.toString();
    }
}