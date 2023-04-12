#include <stdio.h>

int main(void)
{
	int lower = 0, upper = 0;
	register int each, total;

	printf("Lower and Upper Limits: ");
	scanf("%d%d", &lower, &upper);

	for(total = 0, each = lower; each <= upper; ++each)
	{
		total += each * each;
	}

	printf("Sum of Squares = %d\n", total);
}

