package tourism;

import java.util.*;

public class Visitor implements java.io.Serializable {

	String id;
	int visitCount;
	Date lastVisit;
	//field declared with transient modifier is not included
	//in the serialization stream
	transient long ticket;
	static final long serialVersionUID = 1L;

	public Visitor(String name) {
		id = name;
	}

	public final String getId() { return id; }

	public final int getVisitCount() { return visitCount; }

	public final Date getLastVisit() { return lastVisit; }

	public final long getTicket() { return ticket; }

	public void visit() {
		visitCount += 1;
		lastVisit = new Date();
		ticket = System.currentTimeMillis() % 1000000;
	}
}

