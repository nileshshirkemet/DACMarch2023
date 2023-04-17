#include "banner1.h"
#include <cstdio>

double BannerPrice(Banner info, int count)
{
	float rate = count < 50 ? 0.80 : 0.75;
	return rate * count * info.Area(); //Banner::Area(&info)
}

int main(void)
{
	Banner mybanner(20, 8); //automatic activation (on stack)
	float w, h;
	int n;

	printf("Dimensions of your Banner: ");
	scanf("%f%f", &w, &h);
	printf("Number of Banners: ");
	scanf("%d", &n);

	Banner yourbanner(w, h);
	yourbanner.ApplyBorder(true); //Banner::ApplyBorder(&yourbanner, true)

	printf("Total price for my banners = %.2lf\n", BannerPrice(mybanner, n));
	printf("Total price for your banners = %.2lf\n", BannerPrice(yourbanner, n));

}

