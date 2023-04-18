#include "banner3.h"
#include <cstdio>

int main(void)
{
	int n;

	printf("Number of Banners: ");
	scanf("%d", &n);

	//Using new[] operator to explicitly allocate memory for a specified number
	//of instances of specified class, initializing these instances by calling 
	//default constructor and acquiring the pointer to the first instance.
	Banner* ourbanners = new Banner[n]; // non paramerised
	for(int i = 0; i < n; ++i)
	{
		ourbanners[i].Resize(3 * i + 20, 2 * i + 5);
		printf("Price of banner number %d is %.2lf\n", i + 1, 0.80 * ourbanners[i].Area());
	}
	//Using delete[] to deallocate memory assigned to an array of instances
	//addressed by the specified pointerafter calling the destructor 
	//for each of those instances.
	delete[] ourbanners;
}

