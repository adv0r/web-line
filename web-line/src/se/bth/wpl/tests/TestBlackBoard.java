package se.bth.wpl.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.bth.wpl.advcontentmkr.AdvContent;
import se.bth.wpl.advcontentmkr.IAdvContent;

@SuppressWarnings("serial")
public class TestBlackBoard extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // ..... process request

	    // ..... then respond
	
		IAdvContent iac= new AdvContent();
		String [] p= {"antonella fammi studiare..."};
		iac.addPlugin("AnalyticsPlugin", p);
		iac.addPlugin("DiggPlugin", null);
		iac.createAdvContent();
		
		//String AnalyticsCode = new AdvContent().addPlugin("AnalyticsPlugin", null).createAdvContent();
	}
}
