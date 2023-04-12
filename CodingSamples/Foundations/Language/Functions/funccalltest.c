#include <stdio.h>

double BannerPrice(float length, float breadth, int copies)
{
	float rate = copies < 50 ? 0.75 : 0.65;
	return rate * length * breadth * copies;
}

int main(void)
{
	float w, h;
	int n;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &w, &h);
	printf("Number of Banners: ");
	scanf("%d", &n);

	printf("Total Price of Banners without border = %.2lf\n", BannerPrice(w, h, n));
	printf("Total Price of Banners with borders = %.2lf\n", BannerPrice(w + 0.5, h + 0.5, n));
}

