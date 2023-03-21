

import java.util.Arrays;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean map[][] = new boolean[100][100];

		int p = sc.nextInt();


		for (int pn = 0; pn < p; pn++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j]= true;

				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == true) {
					cnt += 1;
					

					
				}
			}
		}

		System.out.println(cnt);
	}

}
//	