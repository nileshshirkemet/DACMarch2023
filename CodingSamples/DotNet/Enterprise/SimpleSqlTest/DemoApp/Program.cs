using var connection = new Microsoft.Data.Sqlite.SqliteConnection();
connection.ConnectionString = "Data Source=shop.db";
connection.Open();
using var command = connection.CreateCommand();
if(args.Length == 0)
{
    command.CommandText = "SELECT ProductNo, Price, Stock FROM ProductInfo";
    using var reader = command.ExecuteReader();
    while(reader.Read())
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", reader.GetInt32(0), reader.GetDecimal(1), reader.GetInt32(2));
}
else
{
    int pno = int.Parse(args[0]);
    command.CommandText = $"UPDATE ProductInfo SET Stock=Stock+5 WHERE ProductNo={pno}";
    int n = command.ExecuteNonQuery();
    if(n == 0)
        Console.WriteLine("No such product!");
}
