namespace Taxation;

public interface ITaxPayer
{
    decimal AnnualIncome();

    decimal IncomeTax()
    {
        decimal extra = AnnualIncome() - 120000;
        return extra > 0 ? 0.15M * extra : 0;
    }
}
