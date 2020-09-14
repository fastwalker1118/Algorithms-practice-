#include <iostream>
#include <vector>

std::vector<int> id;

int root(int i) {
	while (i != id[i]) {
		i = id[i];
	}
	return i;
}

bool connected(int p, int q) {
	if (root(p) == root(q)) {
		return true;
	}
	else {
		return false;
	}
}

void unionn(int p, int q) {
	int i = root(p);
	int j = root(q);
	id[i] = j;
}

/*int main()
{
    int n = 9;
    for (int i = 0; i < 9; i++) {
        id.push_back(i);
    }
    unionn(3, 7);
	unionn(4, 3);
	unionn(5, 4);
	root(3);
    for (int i = 0; i < 9; i++) {
        std::cout << id[i] << std::endl;
    }
}*/