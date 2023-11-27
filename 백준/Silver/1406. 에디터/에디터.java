import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    // 영어 소문자 600,000자 입력 가능
    // 커서 : 문장 맨 앞 , 문장 맨 뒤, 중간 임의의 곳
    // 즉 문자의 길이가 L인 문자열의 놈의 가능한 커서 위치는 N + 1임
    // L -> 커서를 왼쪽으로 한 칸 => 커서가  문장 맨 앞이면 무시
    // D -> 커서를 오른쪽으로 한 칸 => 맨 뒤면 무시
    // B => 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
    //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
    // P $	$라는 문자를 커서 왼쪽에 추가함

    // LinkedList  -> index로 append 핻주기
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String str = br.readLine();
//        int M = Integer.parseInt(br.readLine());
//
//        LinkedList<Character> list = new LinkedList<Character>();
//
//        for(int i = 0; i < str.length(); i++) {
//            list.add(str.charAt(i));
//        }
//
//        //index 변수를 이용해 cursor의 위치를 다루고자 함
//        int index = list.size(); //처음 시작시 커서는 문장의 맨 뒤에서 시작해야함 (ex. abc|)
//
//        for(int i = 0; i < M; i++) {
//            String command = br.readLine();
//            char c = command.charAt(0);
//
//            switch(c) {
//                case 'L':
//                    if(index != 0) {
//                        index = index - 1;
//                    }
//
//                    break;
//                case 'D':
//                    if(index != list.size()) {
//                        index = index + 1;
//                    }
//
//                    break;
//                case 'B':
//                    if(index != 0) {
//                        list.remove(index-1);
//                        index--;
//                    }
//                    break;
//                case 'P':
//                    char t = command.charAt(2);
//                    list.add(index, t);
//                    index++;
//
//                    break;
//                default:
//                    break;
//            }
//        }
//        for(Character chr : list) {
//            bw.write(chr);
//        }
//
//        bw.flush();
//        bw.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        //iterator 메소드 호출
        ListIterator<Character> iter = list.listIterator();
        //처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨뒤로 이동시켜줌 (ex. abc|)
        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch(c) {
                case 'L':
                    if(iter.hasPrevious()) //hasNext() 다음 요소 있으면 true 없으면 false
                        iter.previous(); // previous 이전 요소 반환

                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next(); //next() 	iteration의 다음 요소 반환

                    break;
                case 'B':
                    //remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거함
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove(); // remove() 컬렉션에서 객체를 제거
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);

                    break;
                default:
                    break;
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }


}