import java.net.*;

class Server {

	public static void main(String[] args) throws Exception {
		var store = new java.util.Properties();
		try(var input = new java.io.FileInputStream("CitiTek.xml")){
			store.loadFromXML(input);
		}
		var endpoint = new InetSocketAddress(4080);
		var server = com.sun.net.httpserver.HttpServer.create(endpoint, 10);
		server.createContext("/shopping", client -> {
			String item = client.getRequestURI()
							.getPath()
							.substring(10);
			String info = store.getProperty(item);
			if(info != null){
				byte[] content = info.getBytes("UTF-8");
				client.sendResponseHeaders(200, content.length);
				var output = client.getResponseBody();
				output.write(content);
				output.close();
			}else{
				client.sendResponseHeaders(404, -1);
			}
		});
		server.start();
	}

}

