using System.Text.Json;

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
        string doc = Title + ".json";
        try
        {
            using FileStream output = File.OpenWrite(doc);
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
        string doc = name + ".json";
        try
        {
            using FileStream input = File.OpenRead(doc);
            return JsonSerializer.Deserialize<Site>(input)!;
        }
        catch
        {
            return new Site { Title = name };
        }
    }
}