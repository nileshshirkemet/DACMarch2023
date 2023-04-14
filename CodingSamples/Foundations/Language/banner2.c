#include "banner2.h"

//a function should accept a user-defined type argument through
//a pointer type parameter to avoid copying of data, and such a
//parameter should be declared with const qualifier if this 
//function treats the addressed data as read-only
static double BannerArea(const struct Banner* b)
{
	//b->width = 0;
	switch(b[0].shape)
	{
		case Triangular:
			return 0.5 * b->width * b->height;
		case Elliptical:
			return 0.785 * b->width * b->height;
		default:
			return b->width * b->height;
	}

}

double BannerPrice(struct Banner poster, int count)
{
	float rate = count < 50 ? 0.80 : 0.75;
	return rate * count * BannerArea(&poster);
}

