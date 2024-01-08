import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            LinkedList<Character> commandlist = new LinkedList<>();
            ListIterator<Character> iter = commandlist.listIterator();

            for (int j = 0; j < str.length(); j++) {
                char command = str.charAt(j);

                switch (command) {
                    case '<':
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(command);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : commandlist) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }
}