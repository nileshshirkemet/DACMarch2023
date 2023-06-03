using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Authentication;
using System.Security.Claims;
using DBWebApp.Data;

namespace DBWebApp.Pages;


public class IndexModel : PageModel
{
    private ShopDbContext _db;

    public IndexModel(ShopDbContext db)
    {
         _db = db;
    }

    [BindProperty]
    public Customer Input { get; set; }

    public void OnGet()
    {
        Input = new Customer();
    }

    public async Task<IActionResult> OnPostAsync()
    {
        var customer = await _db.Customers.FindAsync(Input.Id);
        if(customer?.Password == Input.Password)
        {
            var identity = new ClaimsIdentity("Customer");
            identity.AddClaim(new Claim(ClaimTypes.Name, Input.Id));
            await HttpContext.SignInAsync(new ClaimsPrincipal(identity));
            return RedirectToPage("Detail");
        }
        ModelState.AddModelError("Login", "Invalid Customer ID or Password");
        return Page();
    }

}