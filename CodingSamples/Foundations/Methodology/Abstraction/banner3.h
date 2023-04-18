#include <cstdio>

enum BorderStyle {None, Thin, Thick};

class Banner
{
public:
	//optional parameters of functions are initialized with default arguments
	//which are implicitly passed when the corresponding arguments are not
	//passed by the caller ,  new Banner()
	Banner(float w = 20, float h = 8)
	{
		width = w;
		height = h;
		border = BorderStyle::None;
		puts("Banner instance initialized.");
	}
	

	void ApplyBorder(bool yes = true)
	{
		border = yes ? BorderStyle::Thin : BorderStyle::None; 
	}

	void ApplyBorder(BorderStyle style)
	{
		border = style;
	}

	void Resize(float w, float h) 
	{
		width = w;
		height = h;
	}

	double Area() const
	{
		if(width < height)
			throw width; //throw statement exits the function by
						 //transferring control into the exception
					     //handler with matching type
		float t;
		switch(border)
		{
			case BorderStyle::Thin:
				t = 1;
				break;
			case BorderStyle::Thick:
				t = 3;
				break;
			default:
				t = 0;
		}
		return (width + 2 * t) * (height + 2 * t);
	}

	//A destructor is a special member function implemented to remove
	//any side sffect of the constructor. It is automatically called 
	//just before object is removed from the memory or its direct 
	//identifier goes out of scope.
	~Banner()
	{
		puts("Banner instance finalized.");
	}
private:
	float width;
	float height;
	BorderStyle border;
};

