delegate float InterestRate(int period);

class Investment
{
    public double Installment { get; }

    public int Years { get; }

    public Investment(double installment, int years)
    {
        Installment = installment;
        Years = years;
    }

    public double FutureValue(InterestRate rate)
    {
        float i = rate.Invoke(Years) / 100;
        return (Installment / i) * (Math.Pow(1 + i, Years) - 1);
    }
}