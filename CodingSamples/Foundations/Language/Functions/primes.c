//a function declared with static qualifier is only visible in
//the current module
static int IsPrime(long int n)
{
	register int m = 0;

	if(n == 1)
		return 0;
	if(n == 2 || n == 3)
		return 1;
	if((n % 2) == 0)
		return 0;
	for(m = 3; m * m <= n; m += 2)
	{
		if((n % m) == 0)
			return 0;
	}
	return 1;
}

//a non-static function declaration is shared across different modules
int CountPrimes(long int lower, long int upper)
{
	register int count = 0;
	register int n;

	for(n = lower; n <= upper; ++n)
	{
		count += IsPrime(n);
	}

	return count;
}

