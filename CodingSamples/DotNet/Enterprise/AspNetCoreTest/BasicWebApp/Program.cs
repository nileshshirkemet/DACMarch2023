var builder = WebApplication.CreateBuilder(args);

var app = builder.Build();
app.UseStaticFiles();
app.UseMiddleware<BasicWebApp.Middlewares.Pausing>();
app.MapGet("/Welcome", DoGreeting);
app.Run();