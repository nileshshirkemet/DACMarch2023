var builder = WebApplication.CreateBuilder(args);
builder.Services.AddGrpc(); //enable GRPC
var app = builder.Build();
app.MapGrpcService<ServerApp.Shopping.OrderManagerService>();
//For GRPC make kestrel listen on HTTP/2 endpoint
//see appsettings.json
app.Run("http://localhost:4030");
