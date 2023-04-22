#include <time.h>

int DoWork(int seed, int count)
{
	clock_t future = clock() + CLOCKS_PER_SEC * count / 10;
	while(clock() < future);
	return seed + count;
}

