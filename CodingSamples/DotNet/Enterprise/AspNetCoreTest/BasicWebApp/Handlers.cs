//the definition of a class declared with partial
//keyword can be divided into different source file
partial class Program
{
    public static async Task DoGreeting(HttpResponse response, string guest = "Visitor")
    {
        await response.WriteAsync(
            $"""
            <html>
                <head>
                    <title>BasicWebApp</title>
                </head>
                <body>
                    <h1>Welcome {guest}</h1>
                    <b>Current Time: </b>{DateTime.Now}
                </body>
            </html>
            """
        );
    }

    public static async Task DoCounting(HttpRequest request, HttpResponse response, ICounter counter)
    {
        string visitor = request.Form["guest"];
        if(visitor.Length == 0)
            response.Redirect("formpost.html?noname=true");
        else
        {
            string[] intervals = {"Night", "Morning", "Afternoon", "Evening"};
            await response.WriteAsync(
                $"""
                <html>
                    <head>
                        <title>BasicWebApp</title>
                    </head>
                    <body>
                        <h1>Good {intervals[DateTime.Now.Hour / 6]} {visitor}</h1>
                        <b>Number of Greetings: </b>{counter.CountNext(visitor)}
                    </body>
                </html>
                """
            );
        }
    }
}