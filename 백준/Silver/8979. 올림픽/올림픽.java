import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int id;  // 국가 번호
        int gold;
        int silver;
        int bronze;
        public Node(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        // 메달 순으로 정렬: 금 -> 은 -> 동
        @Override
        public int compareTo(Node o) {
            if (this.gold != o.gold) return o.gold - this.gold;
            if (this.silver != o.silver) return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int targetCountry = Integer.parseInt(st.nextToken());

        List<Node> countries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Node(id, gold, silver, bronze));
        }

        // 메달 수 기준으로 내림차순 정렬
        Collections.sort(countries);

        // 순위 계산
        int rank = 1; // 현재 순위
        int sameRankCount = 1; // 동일 순위의 국가 수
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(countries.get(0).id, rank); // 1등

        for (int i = 1; i < countries.size(); i++) {
            Node current = countries.get(i);
            Node previous = countries.get(i - 1);

            // 이전 국가와 메달 수가 같으면 동일한 순위
            if (current.gold == previous.gold && current.silver == previous.silver && current.bronze == previous.bronze) {
                rankMap.put(current.id, rank);
                sameRankCount++;
            } else {
                rank += sameRankCount; // 동일 순위 수만큼 건너뜀
                rankMap.put(current.id, rank);
                sameRankCount = 1;
            }
        }

        
        System.out.println(rankMap.get(targetCountry));
    }
}