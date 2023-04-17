#include "banner3.h"
#include <cstdio>

/*
A reference type (T&) identifier implicitly addresses one variable of
matching type(T) in the initializer and automatically indirects to the
value of that variable. In a function, accepting an argument of an object
type through a const qualified parameter of corresponding reference type
is logically equivalent to accepting the argument by value but without
requiring construction and destruction of a copy of the instance passed
in that argument.
*/

double BannerPrice(const Banner& info, int count)
{
	float rate = count < 50 ? 0.80 : 0.75;
	return rate * count * info.Area();
}

int main(void)
{
	Banner mybanner;
	float w, h;
	int n;

	printf("Dimensions of your Banner: ");
	scanf("%f%f", &w, &h);
	printf("Number of Banners: ");
	scanf("%d", &n);

	Banner yourbanner(w, h);
	yourbanner.ApplyBorder(); 

	printf("Total price for my banners = %.2lf\n", BannerPrice(mybanner, n));
	printf("Total price for your banners = %.2lf\n", BannerPrice(yourbanner, n));
	yourbanner.ApplyBorder(BorderStyle::Thick);
	printf("Total price for your banners with thick border = %.2lf\n", BannerPrice(yourbanner, n));
}

