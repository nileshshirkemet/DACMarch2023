using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authorization;

namespace DBWebApp.Pages;

using Data;

[Authorize]
[ResponseCache(NoStore = true)]
public class DetailModel : PageModel
{
    private ShopDbContext _db;

    public DetailModel(ShopDbContext db) => _db = db;

    public Customer Current { get; set; }

    public async Task OnGetAsync()
    {
        Current = await _db.Customers.FindAsync(User.Identity.Name);
        await _db.Entry(Current).Collection(c => c.Orders).LoadAsync();
    }

    public async Task<IActionResult> OnGetLogoutAsync()
    {
        await HttpContext.SignOutAsync();
        return RedirectToPage("Index");
    }

}