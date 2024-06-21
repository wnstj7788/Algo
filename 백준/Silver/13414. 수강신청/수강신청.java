import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		String tmp;

		for(int i=0;i<l;i++){
			tmp = br.readLine();
			if(hs.contains(tmp)) hs.remove(tmp);
			hs.add(tmp);
		}
		Iterator<String> it = hs.iterator();
		while(it.hasNext()){
            sb.append(it.next() + "\n");
            if(--k < 1) break;
		}

        System.out.println(sb.toString());
		
		
	}
}