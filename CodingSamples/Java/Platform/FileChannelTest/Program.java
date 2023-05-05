import java.nio.file.*;
import java.nio.channels.*;

class Program {

	public static void main(String[] args) throws Exception {
		Path doc = Path.of(args[0]);
		try(var channel = FileChannel.open(doc, StandardOpenOption.READ, StandardOpenOption.WRITE)){
			try(var lock = channel.lock()){
				long n = channel.size();
				var buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, n);
				Transformer.transform(buffer);
			}
		}
	}
}

