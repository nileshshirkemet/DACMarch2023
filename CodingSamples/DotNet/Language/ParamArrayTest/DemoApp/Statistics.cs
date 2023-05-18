class Statistics
{
    public static double Average(double first, double second)
    {
        return (first + second) / 2;
    }

    public static double Average(double first, double second, double third)
    {
        return (first + second + third) / 3;
    }

    //an array type (last) parameter declared with 'params' keyword
    //can accept multiple arguments through that array
    public static double Average(double first, double second, params double[] other)
    {
        double total = first + second;
        foreach(double value in other)
        {
            total += value;
        }
        return total / (2 + other.Length);
    }

    //a parameter declared with 'out' keyword can accept
    //a reference (like ref) to an uninitialized argument
    //but this parameter must be initialized before control
    //leaves the method
    public static double AverageWithDeviation(double first, double second, out double delta)
    {
        delta = first > second ? (first - second) / 2 : (second - first) / 2;
        return Average(first, second);
    }
    
}