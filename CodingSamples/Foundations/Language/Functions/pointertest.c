#include <stdio.h>

double Average(double first, double second, double* delta)
{
	*delta = first > second ? (first - second) / 2 : (second - first) / 2;
	return (first + second) / 2;
}

int main(void)
{
	double a = 0, b = 0, c = 0, d = 0;

	printf("Two Numbers: ");
	scanf("%lf%lf", &b, &c);

	a = Average(b, c, &d);

	printf("Average = %lf with a deviation = %lf\n", a, d);
}

