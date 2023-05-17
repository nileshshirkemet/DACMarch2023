using System;

class Investment
{
    //method declared with static modifier can be called
    //on the class (using . operator) and as such it can
    //only refer to other static members of its type
    public static double FutureValue(double installment, int period, bool risk = false)
    {
        float i = risk ? 0.11f : 0.06f;
        return (installment / i) * (Math.Pow(1 + i, period) - 1);
    }
}
