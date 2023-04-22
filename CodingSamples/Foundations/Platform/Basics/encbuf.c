char salt = '#';

int Transform(char bytes[], int count)
{
	register int i;

	for(i = 0; i < count; ++i)
	{
		//Compiling code which uses direct addressing for referencing
		//a global symbol (salt) does not produce a relocatable object module
		//and as such it cannot be a part of a dynamically linkable library.
		//To produce a relocatable module the code must be compiled with
		//-fPIC to force generation of position-independent code.
		bytes[i] ^= salt;
	}

	return count;
}

