namespace Tourism;

public class Visitor
{
    public string Id { get;}

    public int VisitCount { get; set; }

    public DateTime LastVisit { get; set; }

    [System.Text.Json.Serialization.JsonIgnore]
    public long Ticket { get; set; }

    public Visitor(string id)
    {
        Id = id;
    }

    public void Visit()
    {
        VisitCount += 1;
        LastVisit = DateTime.Now;
        Ticket = LastVisit.Ticks % 1000000;
    }
}