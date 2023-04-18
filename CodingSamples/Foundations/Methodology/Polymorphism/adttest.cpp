#include "series.h"
#include <cstdio>

double Compute(Series::Sequence* seq, int count)
{
	double total = 0;
	for(int i = 1; i <= count; ++i)
	{
		total += seq->Next();
	}
	return total / count;
}

int main(void)
{
	int n;
	printf("Number of terms: ");
	scanf("%d", &n);

	Series::LinearSequence a(3, 7);
	Series::ExponentialSequence b(3);
	Series::FibonacciSequence c;

	printf("First linear sequence computation result = %.2lf\n", Compute(&a, n));
	printf("First exponential sequence computation result = %.2lf\n", Compute(&b, n));
	printf("First fibonacci sequence computation result = %.2lf\n", Compute(&c, n));
	printf("Second linear sequence computation result = %.2lf\n", Compute(&a, n));
	printf("Second exponential sequence computation result = %.2lf\n", Compute(&b, n));
	printf("Second fibonacci sequence computation result = %.2lf\n", Compute(&c, n));
}

