#include "banner1.h"
#include <stdio.h>

int main(void)
{
	struct Banner mybanner = {20, 8};
	struct Banner yourbanner = {};
	int n;

	printf("Dimensions of your Banner: ");
	scanf("%f%f", &yourbanner.width, &yourbanner.height);
	printf("Number of Banners: ");
	scanf("%d", &n);

	printf("Total price of my banners = %.2lf\n", BannerPrice(mybanner, n));
	printf("Total price of your banners = %.2lf\n", BannerPrice(yourbanner, n));
}

