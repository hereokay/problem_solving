#include <iostream>

using namespace std;

#define MAX 100+1

int n, l, m;


class fish
{
public:
	int x;
	int y;
};

fish f[MAX];

int res = 0;
void calc(int x, int y, int w, int h)
{
	int cnt = 0;


	for (size_t i = 0; i < m; i++)
	{
		if (x <= f[i].x && x + w >= f[i].x &&
			y <= f[i].y && y + h >= f[i].y)
		{
			cnt++;
		}
	}
	if (cnt>res)
	{
		res = cnt;
	}
}

int main()
{
	cin >> n >> l >> m;

	for (size_t i = 0; i < m; i++)
	{
		cin >> f[i].x >> f[i].y;
	}

	l /= 2;
	for (size_t i = 0; i < m; i++)
	{
		for (size_t j = 0; j < m; j++)
		{
			for (size_t k = 1; k < l; k++)
			{
				calc(f[i].x, f[j].y, k, l - k);
			}
		}
	}


	cout << res;
}