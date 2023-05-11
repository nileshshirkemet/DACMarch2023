package basic.web.app;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/count")
public class CountingServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("guest");
		if(name.length() == 0){
			response.sendRedirect("greet");
			return;
		}
		var session = request.getSession(true);
		Integer count = (Integer)session.getAttribute(name);
		if(count == null)
			count = 1;
		session.setAttribute(name, count + 1);
		response.setContentType("text/html");
		var output = response.getWriter();
		output.println("<html>");
		output.println("<head><title>BasicWebApp</title></head>");
		output.println("<body>");
		output.printf("<h1>Hello %s</h1>%n", name);
		output.printf("<b>Number of greetings = </b>%d%n", count);
		output.println("</body>");
		output.println("</html>");
		output.close();
	}
}

