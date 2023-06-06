global using OrderManager = Sales.OrderManager.OrderManagerClient;

var builder = WebApplication.CreateBuilder(args);
//provide a channel bound stub for OrderManager service
builder.Services.AddGrpcClient<OrderManager>(
    options => options.Address = new Uri("http://localhost:4030")
);
//enable controllers without views
builder.Services.AddControllers();
//enable OpenApi documentation and testing
builder.Services.AddSwaggerGen();
var app = builder.Build();
//same as UseStaticFiles but with support for default page (index.html)
app.UseFileServer();
if(app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
app.UseCors(options => options.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader());
//map handlers for controllers using their attributes
app.MapControllers();
app.Run();
