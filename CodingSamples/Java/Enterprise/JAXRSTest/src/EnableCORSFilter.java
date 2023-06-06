package rest.web.app;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebFilter("/api/sales/*")
public class EnableCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain next) throws ServletException, IOException {
		var response = (HttpServletResponse) res;
		response.addHeader("ACCESS-CONTROL-ALLOW-ORIGIN", "*");
		response.addHeader("ACCESS-CONTROL-ALLOW-METHODS", "*");
		response.addHeader("ACCESS-CONTROL-ALLOW-HEADERS", "*");
		next.doFilter(req, res);
	}
}

