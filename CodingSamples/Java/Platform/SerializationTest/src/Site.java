package tourism;

import java.io.*;
import java.util.*;

public class Site implements Serializable {
	
	private String title;
	private List<Visitor> visitors;
	final static long serialVersionUID = 1L;

	public Site(String name) {
		title = name;
		visitors = new ArrayList<Visitor>();
	}

	public final String getTitle() { return title; }

	public final List<Visitor> getVisitors() { return visitors; }

	public Visitor getVisitorByName(String name) {
		return visitors.stream()
					.filter(v -> v.id.equals(name))
					.findFirst()
					.orElseGet(() -> {
						Visitor visitor = new Visitor(name);
						visitors.add(visitor);
						return visitor;
					});
	}

	//using object serialization
	public boolean save() {
		String doc = title + ".store";
		try(var output = new ObjectOutputStream(new FileOutputStream(doc))){
			output.writeObject(this);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	//using object deserialization
	public static Site load(String name) {
		String doc = name + ".store";
		try(var input = new ObjectInputStream(new FileInputStream(doc))){
			return (Site)input.readObject();
		}catch(Exception e){
			return new Site(name);
		}
	}

}
