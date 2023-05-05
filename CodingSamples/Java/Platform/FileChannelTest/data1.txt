import java.io.*;

class Program {

	public static void main(String[] args) throws Exception {
		try(var input = new FileInputStream(args[0])){
			try(var output = new FileOutputStream(args[1])){
				byte[] buffer = new byte[80];
				while(input.available() > 0){
					int n = input.read(buffer, 0, buffer.length);
					Transformer.transform(buffer, n);
					output.write(buffer, 0, n);
				}
			}
		}
	}
}

