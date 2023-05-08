import java.net.*;
import java.net.http.*;

class Program {

	public static void main(String[] args) throws Exception {
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		URI site = URI.create("http://" + args[2] + ":4080/shopping/" + item);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
						.GET()
						.uri(site)
						.build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		if(response.statusCode() == 200){
			String text = response.body();
			var info = ItemInfo.parse(text);
			if(quantity <= info.stock())
				System.out.printf("Total Payment: %.2f%n", quantity * info.price());
			else
				System.out.println("Item out of stock!");
		}else{
			System.out.println("Item not sold!");
		}
	}
}


