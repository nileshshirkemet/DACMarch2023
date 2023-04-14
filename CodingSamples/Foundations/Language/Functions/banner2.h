enum Geometry {Rectangular, Triangular, Elliptical};

struct Banner
{
	float width;
	float height;
	char text[80];
	enum Geometry shape;
};

double BannerPrice(struct Banner, int);

