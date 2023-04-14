class Banner
{
public:
	//Constructor is a member function of a class defined with a name
	//that matches with the name of that class and without any return type.
	//It is called whenever a new instance of the class is initialized.
	//A constructor defined without any parameter or all optional parameters
	//is called the default constructor and such a constructor is defined
	//implicitly (by compiler) for a class which does not explicitly define
	//a constructor.
	Banner(float w, float h)
	{
		width = w;
		height = h;
		border = false;
	}

	//void Banner::ApplyBorder(Banner* this, bool yes)
	void ApplyBorder(bool yes)
	{
		border = yes; //this->border = yes;
	}

	//void Banner::Resize(Banner* this, float w, float h)
	void Resize(float w, float h) 
	{
		width = w; //this->width = w;
		height = h; //this->height = w;
	}

	//double Banner::Area(const Banner* this) 
	double Area() const
	{
		float t = border ? 1 : 0; //float t = this->border ? 1 : 0;
		return (width + 2 * t) * (height + 2 * t); //return (this->width + 2 * t) * (this->height + 2 * t);
	}



private:
	float width;
	float height;
	bool border;
};

