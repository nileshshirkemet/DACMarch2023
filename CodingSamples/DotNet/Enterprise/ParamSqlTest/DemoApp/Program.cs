string customerId = args[0].ToUpper();
int productNo = int.Parse(args[1]);
int quantity = int.Parse(args[2]);
using var con = new Microsoft.Data.SqlClient.SqlConnection();
con.ConnectionString = "Data Source=iitdac.met.edu;Trust Server Certificate=True;Database=Shop1;User ID=dac1;Password=Dac1@1234";
con.Open();
using var cmd = con.CreateCommand();
cmd.Transaction = con.BeginTransaction();
try
{
    cmd.CommandText = "UPDATE Counters SET CurrentValue=CurrentValue+1 WHERE Id='order'";
    cmd.ExecuteNonQuery();
    cmd.CommandText = "SELECT CurrentValue+SeedValue FROM Counters WHERE Id='order'";
    int orderNo = Convert.ToInt32(cmd.ExecuteScalar());
    cmd.CommandText = "INSERT INTO OrderDetail VALUES(@OrdNo, @OrdDt, @CustId, @PNo, @Qty)";
    cmd.Parameters.AddWithValue("@OrdNo", orderNo);
    cmd.Parameters.AddWithValue("@OrdDt", DateTime.Today);
    cmd.Parameters.AddWithValue("@CustId", customerId);
    cmd.Parameters.AddWithValue("@PNo", productNo);
    cmd.Parameters.AddWithValue("@Qty", quantity);
    cmd.ExecuteNonQuery();
    cmd.Transaction.Commit();
    Console.WriteLine("New Order No: {0}", orderNo);
}
catch(Exception ex)
{
    cmd.Transaction.Rollback();
    Console.WriteLine("Order Failed: {0}", ex.Message);
}
