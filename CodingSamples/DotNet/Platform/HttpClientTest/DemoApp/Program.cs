using System.Net;

string item = args[0].ToLower();
int quantity = int.Parse(args[1]);
string url = $"http://{args[2]}:4020/shopping/{item}";
var client = new HttpClient();
try
{
    string message = await client.GetStringAsync(url);
    var info = ItemInfo.Parse(message);
    if(quantity <= info.Stock)
        Console.WriteLine("Total Payment: {0:0.00}", quantity * info.Rate);
    else
        Console.WriteLine("Item out of stock!");
}
catch(HttpRequestException ex) when (ex.StatusCode == HttpStatusCode.NotFound)
{
    Console.WriteLine("Item not sold!");
}
