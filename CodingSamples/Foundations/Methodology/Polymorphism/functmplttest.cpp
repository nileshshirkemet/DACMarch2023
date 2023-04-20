#include <iostream>
#include <string>

/*
void Swap(double& first, double& second)
{
	double third = first;
	first = second;
	second = third;
}

void Swap(std::string& first, std::string& second)
{
	std::string third = first;
	first = second;
	second = third;
}
*/

template<typename T>
void Swap(T& first, T& second) //Swap is a function template with subsitutable type T
{
	T third = first;
	first = second;
	second = third;
}

int main(void)
{
	double dx = 4.56, dy = 5.43;
	std::cout << "Original double values: " << dx << ", " << dy << std::endl;
	Swap(dx, dy); //compiler will generate and call templated Swap function with T=double
	std::cout << "Swapped double values : " << dx << ", " << dy << std::endl;

	std::string sx = "Sunday", sy = "Monday";
	std::cout << "Original string values: " << sx << ", " << sy << std::endl;
	Swap(sx, sy); //compiler will generate and call templated Swap function with T=string
	std::cout << "Swapped string values : " << sx << ", " << sy << std::endl;

	//Swap(dx, sx);
}

