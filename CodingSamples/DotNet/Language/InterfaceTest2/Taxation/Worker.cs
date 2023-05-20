namespace Taxation;

public struct Worker : ITaxPayer
{
    //this property can only be set in the initializer statement
    //ex: Worker w = new Worker { Jobs = 123 };
    public int Jobs { get; init; }

    public decimal AnnualIncome()
    {
        return 200000 + 300 * Jobs;
    }
}