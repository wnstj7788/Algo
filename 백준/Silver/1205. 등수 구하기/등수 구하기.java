import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 현재 랭킹 리스트에 있는 점수의 개수
        int newScore = sc.nextInt(); // 태수의 새로운 점수
        int P = sc.nextInt(); // 랭킹 리스트에 올라갈 수 있는 최대 점수 개수

        List<Integer> rankingList = new ArrayList<>();

        // 현재 랭킹 리스트 입력
        for (int i = 0; i < N; i++) {
            rankingList.add(sc.nextInt());
        }

        // 만약 랭킹 리스트가 비어 있는 경우
        if (N == 0) {
            System.out.println(1); // 새로운 점수가 1등
            return;
        }

        // 새로운 점수를 이분 탐색을 사용하여 삽입할 위치를 찾음
        int position = findRank(rankingList, newScore);

        // 만약 리스트가 꽉 찼고 새로운 점수가 들어갈 자리가 없는 경우
        if (N == P && rankingList.get(N - 1) >= newScore) {
            System.out.println(-1); // 새로운 점수가 랭킹에 들어가지 못함
        } else {
            // 인덱스는 0부터 시작하므로 등수는 position + 1이 됨
            System.out.println(position + 1);
        }
    }

    // 이분 탐색을 이용해 새로운 점수를 삽입할 위치 찾기
    public static int findRank(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        // 이분 탐색을 통해 타겟 점수를 넣을 적절한 위치를 찾음
        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid) <= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // 새 점수가 들어가야 할 위치
    }
}