#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>

using namespace std;

#define MAX 15
int col[MAX];
int N, total = 0;


bool check(int level)
{
	for (int i = 0; i < level; i++)
	{
		if (col[i]==col[level] || abs(col[level]-col[i])==level-i) // x가 같거나 x차y차가 같은경우
		{
			return false;
		}
	}
	return true;
}

void nqueen(int x)
{
	if (x==N){
		total++;
	}
	else {
		for (int i = 0; i < N; i++)
		{
			col[x] = i;
			if (check(x))
			{
				nqueen(x + 1);
			}
		}
	}
}


int main()
{
	ios_base::sync_with_stdio(false);
	//ifstream cin;
	//cin.open("input.txt");

	cin >> N;

	nqueen(0);
	cout << total;


}