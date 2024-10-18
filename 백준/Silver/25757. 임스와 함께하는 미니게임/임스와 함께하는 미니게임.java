import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 인원수가 부족하면 게임을 시작할 수 없음 윳놀이 2, 그림 찾기 3, 원카드 4명
        Set<String> user = new HashSet<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        int gameNum = 0;

        if(gameType.equals("Y")){
            gameNum = 1;
        }else if(gameType.equals("F")){
            gameNum = 2;
        }else{
            gameNum = 3;
        }

        for(int i =0;i<N;i++) {
            user.add(br.readLine());
        }

        int size = user.size();

        int answer = size/gameNum;

        System.out.println(answer);


    }
}