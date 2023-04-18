#include "banner.h"
#include <cstdio>

double BannerPrice(const Banner& info, int copies)
{
	float d = Banner::Discount(copies); //calling static method
	float rate = 0.80 * (1 - d);
	//when a virtual function is called on a pointer/reference, 
	//the invocation is indirected through the v-table addressed
	//by the target instance
	return copies * rate * info.Area();
}

int main(void)
{
	float x, y;
	int n;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &x, &y);
	printf("Number of Copies: ");
	scanf("%d", &n);

	Banner mybanner;
	ClippedBanner yourbanner;
	mybanner.Resize(x, y);
	yourbanner.Resize(x, y);

	printf("Price of my banners = %.2lf\n", BannerPrice(mybanner, n));
	printf("Price of your banners = %.2lf\n", BannerPrice(yourbanner, n));
}

