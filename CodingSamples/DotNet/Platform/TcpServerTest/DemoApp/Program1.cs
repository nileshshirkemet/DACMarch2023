using System.Net;
using System.Net.Sockets;
using System.Xml.Linq;

class Program
{
    static IDictionary<string, string> store;
    
    static void Main(string[] args)
    {
        store = XElement.Load("CitiTek.xml")
                    .Elements("item")
                    .ToDictionary(x => x.Attribute("id").Value, x => x.Value);
        //Step 1
        Socket listener = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        listener.Bind(new IPEndPoint(IPAddress.Any, 4010));
        listener.Listen();
        
        Service(listener);
    }

    static void Service(Socket listener)
    {
        for(;;)
        {
            //Step 2
            Socket connection = listener.Accept();
            //Step 3
            Stream remote = new NetworkStream(connection);
            using StreamReader reader = new StreamReader(remote);
            using StreamWriter writer = new StreamWriter(remote);
            try
            {
                writer.WriteLine("Welcome to CitiTek computers");
                writer.Flush();
                String item = reader.ReadLine();
                if(store.TryGetValue(item, out string info))
                {
                    writer.WriteLine(info);
                    writer.Flush();
                }
            }
            catch {}
            //Step 4
            connection.Close();
        }
    }
}
