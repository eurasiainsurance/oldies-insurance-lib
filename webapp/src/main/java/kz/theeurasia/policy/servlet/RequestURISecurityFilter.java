package kz.theeurasia.policy.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.html", "*.xhtml" })
public class RequestURISecurityFilter implements Filter {

    private static final String[] PROHIBITED_URI_ENDS = new String[] { ".include.html", ".include.xhtml" };

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	String requestURI = httpServletRequest.getRequestURI();
	for (String prohibitedURIEnd : PROHIBITED_URI_ENDS) {
	    if (requestURI.endsWith(prohibitedURIEnd)) {
		httpServletResponse.sendRedirect("/");
		return;
	    }
	}
	chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
