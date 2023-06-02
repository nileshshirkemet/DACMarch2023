namespace BasicWebApp.Controllers;

using Tourism;

public class HomeController : Controller
{
    private Site site = Site.Load("CitiZoo");

    public IActionResult Index()
    {
        return View(site); //default view-name is current method name
    }

    [HttpPost]
    public IActionResult Register(string guest)
    {
        var visitor = site.GetVisitorByName(guest);
        visitor.Visit();
        site.Save();
        return RedirectToAction("Index");
    }
}