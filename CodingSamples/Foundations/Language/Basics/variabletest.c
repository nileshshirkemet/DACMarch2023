#include <stdio.h>

//global variables
float width = 0;
float height = 0;

int main(void)
{
	//local variables
	short int count = 0;
	double payment = 0;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners: ");
	scanf("%hd", &count);
	
	payment = 0.75 * count * width * height;
	printf("Total Payment = %.2lf\n", payment);

}

