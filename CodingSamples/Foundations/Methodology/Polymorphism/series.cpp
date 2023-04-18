#include "series.h"

namespace Series
{
	LinearSequence::LinearSequence(double first, double second)
	{
		current = first;
		step = second - first;
	}

	double LinearSequence::Next()
	{
		double term = current;
		current += step;
		return term;
	}

	ExponentialSequence::ExponentialSequence(double value)
	{
		current = 1;
		base = value;
	}

	double ExponentialSequence::Next()
	{
		double term = current;
		current *= base;
		return term;
	}

	void ExponentialSequence::Reset()
	{
		current = 1;
	}

	FibonacciSequence::FibonacciSequence()
	{
		first = 1;
		second = 0;
	}

	double FibonacciSequence::Next()
	{
		long term = first;
		first += second;
		return second = term;
	}

	void FibonacciSequence::Reset()
	{
		first = 1;
		second = 0;
	}
}

