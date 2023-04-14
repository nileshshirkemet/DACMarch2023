#include <stdio.h>

float PrimarySequence(int term)
{
	return 3 * term + 2;
}

float SecondarySequence(int term)
{
	return term * term + 1;
}

/*
double PrimarySum(int count)
{
	double total = 0;
	int n;

	for(n = 1; n <= count; ++n)
	{
		total += PrimarySequence(n);
	}

	return total;
}

double SecondarySum(int count)
{
	double total = 0;
	int n;

	for(n = 1; n <= count; ++n)
	{
		total += SecondarySequence(n);
	}

	return total;
}
*/

double CommonSum(int count, float (*seq)(int))
{
	double total = 0;
	int n;

	for(n = 1; n <= count; ++n)
	{
		total += seq(n); //call-back
	}

	return total;
}

int main(void)
{
	int t;

	printf("Number of Terms: ");
	scanf("%d", &t);

	//printf("Sum of primary sequence terms   = %lf\n", PrimarySum(t));
	//printf("Sum of primary sequence terms   = %lf\n", PrimarySum(t));
	printf("Sum of primary sequence terms   = %lf\n", CommonSum(t, PrimarySequence));
	printf("Sum of secondary sequence terms = %lf\n", CommonSum(t, SecondarySequence));
}

