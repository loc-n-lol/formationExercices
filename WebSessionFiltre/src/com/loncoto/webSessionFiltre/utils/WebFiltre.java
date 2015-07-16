package com.loncoto.webSessionFiltre.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class WebFiltre
 */
public class WebFiltre implements Filter {

	private String name;
	
    /**
     * Default constructor. 
     */
    public WebFiltre() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(name + " appel de doFilter avant chain");
		System.out.println(name + " request -> " + request.getLocalAddr());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println(name + " appel de doFilter après chain");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		name = fConfig.getFilterName();
		
		System.out.println(name + " init du filtre WebFiltre");
	}

}
