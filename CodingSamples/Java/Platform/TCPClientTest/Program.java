import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

class Program {

	public static void main(String[] args) throws Exception {
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		String host = args[2];
		var connection = SocketChannel.open(StandardProtocolFamily.INET);
		connection.connect(new InetSocketAddress(host, 4010));
		var reader = new BufferedReader(Channels.newReader(connection, "UTF-8"));
		var writer = new PrintWriter(Channels.newWriter(connection, "UTF-8"), true); //opening PrintWriter in auto-flush mode
		System.out.println(reader.readLine());
		writer.println(item);
		String text = reader.readLine();
		if(text != null){
			var info = ItemInfo.parse(text);
			if(quantity <= info.stock())
				System.out.printf("Total Payment: %.2f%n", quantity * info.price());
			else
				System.out.println("Item out of stock!");
		}else{
			System.out.println("Item not sold!");
		}
		writer.close();
		reader.close();
		connection.close();
	}
}


