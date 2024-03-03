import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<Integer, Integer> attackInfo = new HashMap<>();
    static int endTime = 0;
    static int nowHealth = 0;
    static int succTime = 0;

    public int solution(int[] bandage, int health, int[][] attacks) {
        nowHealth = health;
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]); // 공격, 데미쥐
            endTime = attack[0];
        }

        for (int i = 1; i <= endTime; i++) {
            if (attackInfo.containsKey(i)) { // 해당 시간에 맞는 공격이 있다
                nowHealth -= attackInfo.get(i); // 체력 죽이기 
                succTime = 0;
            } else { // 공격이 없다면
                nowHealth += bandage[1];
                succTime++;

                if (succTime == bandage[0]) { // 연속 성공
                    nowHealth += bandage[2]; // 추가 회복 
                    succTime = 0; // 0으로 초기화 
                }
                if (nowHealth > health) { // 최대 체력 이상이면 멈춰 
                    nowHealth = health;
                }
            }

            if (nowHealth <= 0) { // 0 하면 멈춰 
                return -1;
            }
        }

        return nowHealth;
    }
}