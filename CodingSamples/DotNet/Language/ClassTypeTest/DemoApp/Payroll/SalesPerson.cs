namespace Payroll
{
    //SalesPerson is a derived class of Employee
    //which is called its base class
    class SalesPerson : Employee
    {
        //automatic property
        public double Sales { get; set; }

        public SalesPerson(int h, float r, double s) : base(h, r)
        {
            Sales = s;
        }

        //method overriding - implementing a method in
        //a dervied class which is declared as virtual
        //in the base class with same return type and
        //same list of parameter types
        public override double Income()
        {
            double amount = base.Income();
            if(Sales >= 20000)
                amount += 0.05 * Sales;
            return amount;
        }

    }
}