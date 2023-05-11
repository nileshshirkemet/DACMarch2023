package basic.web.app;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;

public class GreetingServlet implements Servlet {

	private ServletConfig config;

	public void init(ServletConfig cfg) throws ServletException { config = cfg; }

	public ServletConfig getServletConfig() { return config; }

	public String getServletInfo() { return "Greeting Servlet"; }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String guest = request.getParameter("name");
		if(guest == null)
			guest = "Visitor";
		response.setContentType("text/html");
		var output = response.getWriter();
		output.println("<html>");
		output.println("<head><title>BasicWebApp</title></head>");
		output.println("<body>");
		output.printf("<h1>Welcome %s</h1>%n", guest);
		output.printf("<b>Current Time:</b>%s%n", new Date());
		output.println("</body>");
		output.println("</html>");
		output.close();
	}

	public void destroy() {}
}

