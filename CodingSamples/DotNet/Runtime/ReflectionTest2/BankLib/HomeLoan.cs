namespace Finance;

public class HomeLoan
{
    public double Common(double amount, int period) => amount < 5000000 ? 9 : 8.5;
}
