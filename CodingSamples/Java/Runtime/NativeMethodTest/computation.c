#include "Computation.h"

JNIEXPORT jlong JNICALL Java_Computation_gcdOf(JNIEnv* env, jclass cls, jlong first, jlong second)
{
	while(first != second)
	{
		if(first > second)
			first -= second;
		else
			second -= first;
	}
	return first;
}

