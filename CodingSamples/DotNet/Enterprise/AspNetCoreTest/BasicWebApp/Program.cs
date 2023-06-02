global using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
//builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddTransient<ICounter, NamedCounter>();
var app = builder.Build();
app.UseStaticFiles();
app.UseMiddleware<BasicWebApp.Middlewares.Pausing>();
app.MapGet("/Welcome", DoGreeting);
app.MapPost("/Count", DoCounting);
app.Run();