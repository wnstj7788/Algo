#include <iostream>
#include <vector>



int main() {
	int coin[6] = { 500,100,50,10,5,1 };
	int money, cnt = 0;

	std::cin >> money;

	int target = 1000 - money;

	for (int i = 0; i < 6; i++) {
		while (target >= coin[i]) {
			target -= coin[i];
			cnt++;
		}
	}

	std::cout << cnt;




	return 0;
}