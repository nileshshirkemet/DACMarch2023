class Computation
{
    public unsafe static double Compute(double[] values)
    {
        double sum = 0;
        double* pSum = &sum; //taking address of a value on stack
        //to take an address of a value within an object/array
        //on the heap, this object/array must be pinned (fixed)
        //so that it is not moved during garbage collection
        fixed(double* pValues = &values[0])
        {
            for(int i = 0; i < values.Length; ++i)
            {
                *pSum += pValues[i] * pValues[i];
            }
        }
        return sum;
    }
}