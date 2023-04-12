#include <stdio.h>

//a function declared with extern qualifier is defined in some other module
extern long long int GCD(long long int, long long int);

int main(void)
{
	long long int m, n;

	printf("Two Positive Integers: ");
	scanf("%lld%lld", &m, &n);

	printf("L.C.M = %lld\n", m * n / GCD(m, n));
}

