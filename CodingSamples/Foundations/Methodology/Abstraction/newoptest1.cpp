#include <cstdio>
#include "banner3.h"

int main(void)
{
	//Using new operator to explicitly allocate memory for a new instance
	//of the specified class (on runtime heap), initializing this instance 
	//using the specified constructor and acquring the pointer to this instance.
	Banner b; //stack 
	Banner* mybanner = new Banner(); //dynamic activation
	
	float w, h;
	printf("Dimensions of your Banner: ");
	scanf("%f%f", &w, &h);
    
	printf("Price of your banner = %.2lf\n", b.Area());

	Banner* yourbanner = new Banner(w, h);
	yourbanner->ApplyBorder(BorderStyle::Thick);
	printf("Price of my banner = %.2lf\n", 0.80 * mybanner->Area());
	delete mybanner;
	printf("Price of your banner = %.2lf\n", 0.80 * yourbanner->Area());

	//Using delete operator to deallocate memory assigned to the instance
	//addressed by the specified pointer after calling its destructor
	delete mybanner;
	delete yourbanner;
}

