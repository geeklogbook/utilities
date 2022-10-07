#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

#define N 4

int findMinCost(int cost[][N], int n, int lookup[])
{
	if (lookup[n] != 0)
		return lookup[n];

	int min_cost = cost[0][n];

	for (int i = 1; i < n; i++)
	{
		min_cost = min(min_cost, findMinCost(cost, i, lookup) + cost[i][n]);
	}

	return (lookup[n] = min_cost);
}

int main()
{
	int cost[N][N]{
		{0, 20, 30, 100},
		{20, 0, 15, 75},
		{30, 15, 0, 50},
		{100, 75, 50, 0}};

	int lookup[N] = {};

	cout << "The minimun costs is " << findMinCost(cost, N - 1, lookup) << "$";
}
