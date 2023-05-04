#include "quadeqn.h"
#include "LegacyQE.h"

JNIEXPORT jdoubleArray JNICALL Java_LegacyQE_realRoots(JNIEnv* env, jobject obj)
{
	jclass cls = env->GetObjectClass(obj);
	jfieldID idFirst = env->GetFieldID(cls, "first", "D");
	jdouble a = env->GetDoubleField(obj, idFirst);
	jfieldID idSecond = env->GetFieldID(cls, "second", "D");
	jdouble b = env->GetDoubleField(obj, idSecond);
	jfieldID idThird = env->GetFieldID(cls, "third", "D");
	jdouble c = env->GetDoubleField(obj, idThird);

	Algebra::QuadraticEquation eqn(b / a, c / a);
	double roots[2];
	if(eqn.Solve(roots[0], roots[1]))
	{
		jdoubleArray result = env->NewDoubleArray(2);
		env->SetDoubleArrayRegion(result, 0, 2, roots);
		return result;
	}

	jclass ex = env->FindClass("java/lang/IllegalArgumentException");
	env->ThrowNew(ex, "No real roots");

	return NULL;

}

