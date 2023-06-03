var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages();
builder.Services.AddDbContext<DBWebApp.Data.ShopDbContext>();
builder.Services.AddAuthentication()
    .AddCookie(options => options.LoginPath = "/Index");
var app = builder.Build();
app.UseAuthentication();
app.UseAuthorization();
app.MapRazorPages();
app.Run();
