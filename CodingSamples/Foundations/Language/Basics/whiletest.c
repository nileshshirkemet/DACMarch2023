#include <stdio.h>

int main(void)
{
	long int num = 0;
	register long int sum;

	printf("Positive Integer: ");
	scanf("%ld", &num);

	sum = 0;

	while(num > 0)
	{
		sum += num % 10; //sum = sum + num % 10
		num /= 10;	//num = num / 10;
	}

	printf("Sum of Digits = %ld\n", sum);
}

