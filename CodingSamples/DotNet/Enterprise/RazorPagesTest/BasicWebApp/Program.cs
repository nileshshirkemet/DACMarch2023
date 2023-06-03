using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddTransient<ICounter, NamedCounter>();
builder.Services.AddRazorPages(); // enable razor pages
var app = builder.Build();
app.MapRazorPages();
app.Run();
