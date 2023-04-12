#include <stdio.h>

float width = 0;
float height = 0;

int main(void)
{
	short int count = 0;
	double payment = 0;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners: ");
	scanf("%hd", &count);
	
	if(width > height)
	{
		printf("Total payment for landscape banners = %.2lf\n", 0.75 * count * width * height);
	}
	else
	{
		printf("Total payment for portrait banners = %.2lf\n", 0.80 * count * width * height);
	}

	printf("Goodbye Customer!\n");
}

