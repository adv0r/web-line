package se.bth.wpl.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.bth.wpl.utils.SiteMapGenerator;

@SuppressWarnings("serial")
public class TestSiteMap extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // ..... process request

	    // ..... then respond
	    SiteMapGenerator st= new SiteMapGenerator();
	   st.generateSitemap(false, false, false);
	}
}
