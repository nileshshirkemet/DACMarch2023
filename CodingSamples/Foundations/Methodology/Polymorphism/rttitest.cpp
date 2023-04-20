#include "series.h"
#include <cstdio>

//include Series namespace in lookup for unqualified symbols
using namespace Series;

double Compute(Sequence* seq, int count)
{
	double total = 0;
	//explicit (side) casting using dynamic_cast operator which uses
	//runtime-type identification (RTTI) to convert the source pointer (seq)
	//to the destination type (Resetable*) if the type of the instance 
	//addressed by the source matches with or inherits from the destination
	//type otherwise it returns nullptr (zero).
	Resetable* r = dynamic_cast<Resetable*>(seq);
	if(r != nullptr)
		r->Reset();
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

	LinearSequence a(3, 7);
	ExponentialSequence b(3);
	FibonacciSequence c;
	
	//Note: compiler implicitly inserts static_cast operation
	printf("First linear sequence computation result = %.2lf\n", Compute(static_cast<Sequence*>(&a), n));
	printf("First exponential sequence computation result = %.2lf\n", Compute(&b, n));
	printf("First fibonacci sequence computation result = %.2lf\n", Compute(&c, n));
	printf("Second linear sequence computation result = %.2lf\n", Compute(&a, n));
	printf("Second exponential sequence computation result = %.2lf\n", Compute(&b, n));
	printf("Second fibonacci sequence computation result = %.2lf\n", Compute(&c, n));
}

