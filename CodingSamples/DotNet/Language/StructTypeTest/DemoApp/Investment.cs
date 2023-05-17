//user-defined value type
struct Investment
{
    //instance fields
    private double installment;
    private int period;
    private bool risk;

    //constructor - method for initializing a new instance
    public Investment(double amount, int years)
    {
        installment = amount;
        period = years;
        risk = false;
    }

    //instance (non-static) method must be called
    //on an object of its type (using . operator) and
    //it can refer to other instance members through
    //the hidden 'this' argument which refers to the 
    //object on which it is called 
    public void AllowRisk(bool yes)
    {
        risk = yes; //this.risk = yes
    }

    public double TotalAmount()
    {
        return installment * period;
    }

    public double FutureValue()
    {
        float i = risk ? 0.11f : 0.06f;
        return (installment / i) * (Math.Pow(1 + i, period) - 1);
    }
}
