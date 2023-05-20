namespace Taxation;

public struct Supervisor : ITaxPayer
{
    public int Span { get; init; }

    public decimal AnnualIncome()
    {
        return 300000 + 10000 * Span;
    }
}
