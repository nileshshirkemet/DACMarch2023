namespace BasicWebApp.Controllers;

public class SimpleController : Controller
{
    public IActionResult Secret()
    {
        var rdm = new Random();
        return Content($"Your pass-code is {rdm.Next(100000, 1000000)}");
    }

    public IActionResult Greet(string id, [FromServices] ICounter ctr)
    {
        var guest = new 
        {
            Who = id ?? "Visitor",
            When = DateTime.Now
        };
        int count = ctr.CountNext(id);
        if((count % 2) == 1)
        {
            //View method renders ~/Views/<controller-name>/<page-name>.cshtml
            return View("Welcome", guest);
        }
        return View("Hello", guest);
    }
}
