#include <stdio.h>

extern int CountPrimes(long int, long int);

int main(void)
{
	long int p, q;

	printf("Lower and Upper Limits: ");
	scanf("%ld%ld", &p, &q);

	printf("Number of Primes = %d\n", CountPrimes(p, q));
}

