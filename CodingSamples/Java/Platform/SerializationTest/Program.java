import tourism.*;

class Program {

	public static void main(String[] args) {
		var site = Site.load("CitiZoo");
		if(args.length > 0){
			var visitor = site.getVisitorByName(args[0]);
			visitor.visit();
			System.out.printf("Welcome %s, your ticket-number is %d%n", visitor.getId(), visitor.getTicket());
			site.save();
		}else{
			for(var visitor : site.getVisitors())
				System.out.printf("%s\t%d\t%s%n", visitor.getId(), visitor.getVisitCount(), visitor.getLastVisit());
		}
	}
}



