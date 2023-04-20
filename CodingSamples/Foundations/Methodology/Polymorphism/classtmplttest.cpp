#include <iostream>
#include <string>

template<typename V>
class Selector //Selector is a class template with substitutable type V
{
public:
	Selector(const V& a, const V& b) : first(a), second(b)
	{
	}

	V Select(int index) const
	{
		if((index % 2) == 1)
			return first;
		return second;
	}

private:
	V first;
	V second;
};

int main(void)
{
	int n;
	std::cout << "Index: ";
	std::cin >> n;

	Selector<double> sd(4.56, 5.43); //compiler will generate templates Selector class with T=double
	std::cout << "Selected double value = "
			  << sd.Select(n)
			  << std::endl;

	Selector<std::string> ss("Sunday", "Monday");
	std::cout << "Selected string value = "
			  << ss.Select(n)
			  << std::endl;

	//Selector<int> si(123, "abcd");
}

