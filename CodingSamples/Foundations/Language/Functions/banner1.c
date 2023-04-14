#include "banner1.h"

double BannerPrice(struct Banner poster, int count)
{
	float rate = count < 50 ? 0.80 : 0.75;
	return rate * count * poster.width * poster.height;
}

