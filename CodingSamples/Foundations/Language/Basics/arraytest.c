#include <stdio.h>

/*
An array is a varaiable which identifies multiple values of same size
closely packed one after another in the memory. For an array containing
N elements, each element is referenced using its index which is in
range 0 to N-1
*/
short int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main(void)
{
	int month = 0;
	short int count = 0;
	
	printf("Month[1-12]: ");
	scanf("%d", &month);

	count = days[month - 1];
	printf("Amount = %hd\n", count * (count + 1) / 2);
}

