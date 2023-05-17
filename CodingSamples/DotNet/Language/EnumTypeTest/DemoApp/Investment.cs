enum RiskLevel {None, Low, High}

struct Investment
{
    private double installment;
    private int period;
    private RiskLevel risk;

    public Investment(double amount, int years)
    {
        installment = amount;
        period = years;
        risk = RiskLevel.None;
    }

    public void AllowRisk(bool yes)
    {
        risk = yes ? RiskLevel.Low : RiskLevel.None;
    }

    //method overloading - defining multiple methods in
    //a type with same name but different list of 
    //parameter types
    public void AllowRisk(RiskLevel level)
    {
        risk = level;
    }

    public double TotalAmount()
    {
        return installment * period;
    }

    public double FutureValue()
    {
        float i;
        switch(risk)
        {
            case RiskLevel.Low:
                i = 0.11f;
                break;
            case RiskLevel.High:
                i = 0.15f;
                break;
            default:
                i = 0.06f;
                break;
        }
        return (installment / i) * (Math.Pow(1 + i, period) - 1);
    }
}
