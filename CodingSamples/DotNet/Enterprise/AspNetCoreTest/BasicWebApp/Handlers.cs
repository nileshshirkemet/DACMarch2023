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
}