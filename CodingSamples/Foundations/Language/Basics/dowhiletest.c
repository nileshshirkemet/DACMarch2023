#include <stdio.h>

int main(void)
{
	long int num = 0;
	register long int a, b, c;

	printf("Positive Integer: ");
	scanf("%ld", &num);

	a = 1;
	b = num >= 0 ? num : -num;
	c = 0;

	do
	{
		c = c + 1;
		a = a * 10;
	}
	while(a <= b);

	printf("Number of Digits = %ld\n", c);
}

