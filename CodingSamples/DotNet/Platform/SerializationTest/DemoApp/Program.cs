using Tourism;

Site site = Site.Load("CitiZoo");
if(args.Length > 0)
{
    Visitor visitor = site.GetVisitorByName(args[0]);
    visitor.Visit();
    Console.WriteLine("Welcome {0}, your ticket-number is {1}", visitor.Id, visitor.Ticket);
    site.Save();
}
else
{
    foreach(Visitor visitor in site.Visitors)
        Console.WriteLine("{0}\t{1}\t{2}", visitor.Id, visitor.VisitCount, visitor.LastVisit);
}