namespace BasicWebApp.Middlewares;

public class Pausing
{
    private RequestDelegate _next;
    private DateTime recent;

    public Pausing(RequestDelegate next)
    {
        _next = next;
    }

    public async Task Invoke(HttpContext context)
    {
        DateTime current = DateTime.Now;
        if(current - recent >= TimeSpan.FromSeconds(3))
        {
            recent = current;
            await _next.Invoke(context);
        }
        else
        {
            await context.Response.WriteAsync("Server is busy, please try after some time...");
        }
    }
}