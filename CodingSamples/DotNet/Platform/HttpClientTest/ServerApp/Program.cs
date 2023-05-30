using System.Net;
using System.Xml.Linq;

var store = XElement.Load("CitiTek.xml")
                .Elements("item")
                .ToDictionary(x => (string)x.Attribute("id"), x => (string)x);
var server = new HttpListener();
server.Prefixes.Add("http://localhost:4020/shopping/");
server.Start();
for(;;)
{
    var client = server.GetContext();
    using var writer = new StreamWriter(client.Response.OutputStream);
    string item = client.Request.Url.Segments[2];
    if(store.TryGetValue(item, out string info))
    {
        client.Response.ContentType = "text/plain";
        writer.WriteLine(info);
    }
    else
    {
        client.Response.StatusCode = 404;
    }
}
