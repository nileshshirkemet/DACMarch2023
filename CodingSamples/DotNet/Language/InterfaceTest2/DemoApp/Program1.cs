using Taxation;

class Program
{
    //nested class - can only refer to static members
    //of its outer class
    class Auditor
    {
        public Auditor()
        {
            Console.WriteLine("Auditing begins...");
        }

        public void Audit(string id, ITaxPayer emp)
        {
            if(id.Length < 4)
                throw new ArgumentException("Invalid ID");
            decimal payment = emp.IncomeTax() + 250;
            Console.WriteLine("Total Tax Payment: {0:0.00}", payment);
        }

        public void Dispose()
        {
            Console.WriteLine("Auditing ends.");
        }
    }

    static void Action(string name, int count)
    {
        ITaxPayer t = name == "jack" ? new Supervisor { Span = count } : new Worker { Jobs = count };
        Auditor a = new Auditor();
        try
        {
            a.Audit(name, t);
        }
        finally
        {
            a.Dispose();
        }
        
    }

    static void Main(string[] args)
    {
        try
        {
            string m = args[0].ToLower();
            int n = int.Parse(args[1]);
            Action(m, n);
        }
        catch(Exception ex)
        {
            Console.WriteLine("Action Failed: {0}", ex.Message);
        }
    }
}