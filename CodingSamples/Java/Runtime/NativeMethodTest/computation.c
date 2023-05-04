#include "Computation.h"
#include <stdlib.h>

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

JNIEXPORT jdouble JNICALL Java_Computation_sumOfSquares(JNIEnv* env, jclass cls, jdoubleArray values)
{
	jint count = (*env)->GetArrayLength(env, values);
	jdouble* items = malloc(count * sizeof(jdouble));
	jdouble result = 0;
	register jint i;

	(*env)->GetDoubleArrayRegion(env, values, 0, count, items);
	for(i = 0; i < count; ++i)
		result += items[i] * items[i];
	free(items);

	return result;
}

