using System.Text.Json;
using System.IO.Compression;

namespace Tourism;

public class Site
{
    public required string Title { get; init; }

    public List<Visitor> Visitors { get; set; } = new();

    public Visitor GetVisitorByName(string name)
    {
        Visitor? visitor = Visitors.Find(e => e.Id == name);
        if(visitor is null)
        {
            visitor = new Visitor(name);
            Visitors.Add(visitor);
        }
        return visitor;
    }

    public bool Save()
    {
        string doc = Title + ".cjson";
        try
        {
            using Stream output = new DeflateStream(File.OpenWrite(doc), CompressionMode.Compress);
            JsonSerializer.Serialize(output, this);
            return true;
        }
        catch
        {
            return false;
        }
    }

    public static Site Load(string name)
    {
        string doc = name + ".cjson";
        try
        {
            using Stream input = new DeflateStream(File.OpenRead(doc), CompressionMode.Decompress);
            return JsonSerializer.Deserialize<Site>(input)!;
        }
        catch
        {
            return new Site { Title = name };
        }
    }
}