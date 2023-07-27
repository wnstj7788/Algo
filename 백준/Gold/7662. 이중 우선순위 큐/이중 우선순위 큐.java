import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc  < TC ; tc++) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (long i = 0; i < cnt; i++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    // I가 들어있냐 없냐
                    if(tree.containsKey(num)){
                        tree.put(num, tree.get(num) +1);
                    }else{
                        tree.put(num, 1);
                    }

                } else if (command.equals("D")) {
                    if(!tree.isEmpty()){
                        if(num == -1){
                            // 최소값 삭제
                            int min = tree.firstKey();
                            if(tree.get(min) == 1){
                                tree.remove(min);
                            }else{
                                tree.put(min,tree.get(min) -1);
                            }

                        } else if (num == 1) {
                          int max = tree.lastKey();
                          if(tree.get(max) == 1){
                              tree.remove(max);
                          }else {
                              tree.put(max, tree.get(max) -1 );
                          }
                        }

                    }

                }


            }

            if(!tree.isEmpty()){
                sb.append(tree.lastKey() + " ");
                sb.append(tree.firstKey() + "\n");
            }else{
                sb.append("EMPTY" + "\n");
            }

        }

        System.out.println(sb.toString());

    }
}