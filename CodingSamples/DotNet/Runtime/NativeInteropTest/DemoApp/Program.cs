if(args[0] == "compute")
{
    double[] values = args.Skip(1)
                        .Select(double.Parse)
                        .ToArray();
    Console.WriteLine(Computation.Compute(values));
}
else if(args[0] == "encrypt")
{
    Console.WriteLine(Encryption.EncryptString(args[1]));
}
