#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

#define N 4

int findMinCost(int cost[][N])
{
	int lookup[N];

	for (int i = 0; i < N; i++)
		lookup[i] = cost[0][i];

	for (int i = 2; i < N; i++)
	{
		for (int j = 1; j < i; j++)
		{
			lookup[i] = min(lookup[i], lookup[j] + cost[j][i]);
		}
	}

	return lookup[N - 1];
}

int main()
{
	int cost[N][N] =
		{
			{0, 20, 30, 100},
			{20, 0, 15, 75},
			{30, 15, 0, 50},
			{100, 75, 50, 0}};

	cout << "The minimun cost is " << findMinCost(cost) << "$";
}