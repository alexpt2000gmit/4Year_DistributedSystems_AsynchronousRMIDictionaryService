package ie.gmit.sw;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {

	
	static LoadDictionary loadDictionary;

	public static void main(String[] args) {

		try {
			// Start the RMI registry on port 1099
			LocateRegistry.createRegistry(1099);
			
			System.err.println("Loading dictionary definition...");
			
			Naming.rebind("//localhost/RMIdictionary", new DictionaryServiceImpl(LoadDictionary.initializeDictionary()));
			System.err.println("Server ready  :-)");
		} catch (Exception e) {
			System.err.println("Server exception " + e.getMessage());
		}

	}
}