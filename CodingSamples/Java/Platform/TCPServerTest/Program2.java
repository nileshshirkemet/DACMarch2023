import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;

class Program {

	private static Properties store = new Properties();

	public static void main(String[] args) throws Exception {
		try(var input = new FileInputStream("CitiTek.xml")){
			store.loadFromXML(input);
		}
		//Step 1
		var listener = ServerSocketChannel.open(StandardProtocolFamily.INET);
		listener.bind(new InetSocketAddress(4010));
		for(int i = 0; i < 5; ++i){
			Thread servant = new Thread(() -> {
				try{
					service(listener);
				}catch(IOException e){}
			});
			servant.start();
		}	
	}

	private static void service(ServerSocketChannel listener) throws IOException {
		for(;;){
			//Step 2
			var connection = listener.accept();
			//Step 3
			var reader = new BufferedReader(Channels.newReader(connection, "UTF-8"));
			var writer = new PrintWriter(Channels.newWriter(connection, "UTF-8"));
			try{
				writer.println("Welcome to CitiTek computers");
				writer.flush();
				String item = reader.readLine();
				String info = store.getProperty(item);
				if(info != null){
					writer.println(info);
					writer.flush();
				}
			}catch(Exception e){}
			writer.close();
			reader.close();
			//Step 4
			connection.close();
		}
	}
}

