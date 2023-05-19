using Payroll; 

class Program 
{
    static void Appraise(Employee? emp)
    {
        if(emp != null && emp.Hours >= 175 && emp is not SalesPerson)
            emp.Rate *= 1.1f;
    }

    static double Tax(Employee emp)
    {
        double i = emp.Income();
        return i > 10000 ? 0.15 * (i - 10000) : 0;
    }

    static void Main()
    {
        Employee jack = new Employee();
        jack.Hours = 186;
        jack.Rate = 52;
        Console.WriteLine("Jack's Income is {0:0.00}, Tax is {1:0.00}", jack.Income(), Tax(jack));
        SalesPerson jill = new SalesPerson(186, 52, 64000);
        Console.WriteLine("Jill's Income is {0:0.00}, Tax is {1:0.00}", jill.Income(), Tax(jill));
        Console.WriteLine("Appraising employees...");
        Appraise(jack);
        Console.WriteLine("Jack's new Income is {0:0.00}", jack.Income());    
        Appraise(jill);
        Console.WriteLine("Jack's new Income is {0:0.00}", jill.Income());
        Appraise(null);
        //Tax(null);
    }   
}