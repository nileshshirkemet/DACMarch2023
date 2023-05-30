using System.Net.Sockets;

string item = args[0].ToLower();
int quantity = int.Parse(args[1]);
//Step1
TcpClient connection = new TcpClient(args[2], 4010);
//Step2
Stream remote = connection.GetStream();
using StreamReader reader = new StreamReader(remote);
using StreamWriter writer = new StreamWriter(remote) { AutoFlush = true };
Console.WriteLine(reader.ReadLine());
writer.WriteLine(item);
string message = reader.ReadLine();
if(message != null)
{
    ItemInfo info = ItemInfo.Parse(message);
    if(quantity <= info.Stock)
        Console.WriteLine("Total Payment: {0:0.00}", quantity * info.Rate);
    else
        Console.WriteLine("Item out of stock!");
}
else
{
    Console.WriteLine("Item not sold!");
}
//Step 3
connection.Close();
