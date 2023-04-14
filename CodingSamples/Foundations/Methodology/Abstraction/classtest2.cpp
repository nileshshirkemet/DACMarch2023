#include "banner2.h"
#include <cstdio>

double BannerPrice(Banner info, int count)
{
	float rate = count < 50 ? 0.80 : 0.75;
	return rate * count * info.Area();
}

int main(void)
{
	Banner mybanner(20, 8);
	float w, h;
	int n;

	printf("Dimensions of your Banner: ");
	scanf("%f%f", &w, &h);
	printf("Number of Banners: ");
	scanf("%d", &n);

	Banner yourbanner(w, h);
	yourbanner.ApplyBorder(true); 

	printf("Total price for my banners = %.2lf\n", BannerPrice(mybanner, n));
	printf("Total price for your banners = %.2lf\n", BannerPrice(yourbanner, n));
	yourbanner.ApplyBorder(BorderStyle::Thick);
	printf("Total price for your banners with thick border = %.2lf\n", BannerPrice(yourbanner, n));

}

