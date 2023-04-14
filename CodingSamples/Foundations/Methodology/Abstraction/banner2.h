enum BorderStyle {None, Thin, Thick};

class Banner
{
public:
	Banner(float w, float h)
	{
		width = w;
		height = h;
		border = BorderStyle::None;
	}

	void ApplyBorder(bool yes)
	{
		border = yes ? BorderStyle::Thin : BorderStyle::None; 
	}

	//function overloading - defining a function whose name matches
	//with another function declared in same scope but with a different
	//list of parameter types
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

private:
	float width;
	float height;
	BorderStyle border;
};

