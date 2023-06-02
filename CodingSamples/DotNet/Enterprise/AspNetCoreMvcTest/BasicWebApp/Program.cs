global using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddControllersWithViews(); //enable MVC
var app = builder.Build();
app.MapDefaultControllerRoute();
app.Run();
