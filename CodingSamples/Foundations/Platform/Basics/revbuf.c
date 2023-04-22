int Transform(char bytes[], int count)
{
	register int i, j;

	for(i = 0, j = count - 1; i < j; ++i, --j)
	{
		char ic = bytes[i];
		char jc = bytes[j];
		bytes[i] = jc;
		bytes[j] = ic;
	}

	return count;
}

