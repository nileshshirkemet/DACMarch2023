import shopping.*;
import java.rmi.registry.*;

class Program {

	public static void main(String[] args) throws Exception {
		var naming = LocateRegistry.createRegistry(4030);
		naming.bind("orderManagement", new OrderManagerService(4030)); 
	}
}

