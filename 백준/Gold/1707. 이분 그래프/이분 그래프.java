import java.io.*;
import java.util.*;

public class Main {
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v + 1];
			arr = new ArrayList[v + 1];

			for (int i = 0; i <= v; i++)
				arr[i] = new ArrayList<Integer>();

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				arr[p1].add(p2);
				arr[p2].add(p1);
			}
			YesOrNo();
		}
	}
// 트리는 사이클을 갖지 않는다를 생각해!
	
	public static void YesOrNo() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= v; i++) {
			if (visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int j = 0; j < arr[now].size(); j++) {
					if (visit[arr[now].get(j)] == 0) {
						q.add(arr[now].get(j));
					}

					if (visit[arr[now].get(j)] == visit[now]) {
						System.out.println("NO");
						return;
					}

					if (visit[now] == 1 && visit[arr[now].get(j)] == 0)
						visit[arr[now].get(j)] = 2;
					else if (visit[now] == 2 && visit[arr[now].get(j)] == 0)
						visit[arr[now].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}