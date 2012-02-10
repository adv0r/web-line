package se.bth.wpl.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.bth.wpl.filesystem.CreateZip;
import se.bth.wpl.filesystem.ICreateZip;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // ..... process request

	    // ..... then respond
	    response.setContentType("application/zip");
	    response.setStatus(HttpServletResponse.SC_OK);
	    ICreateZip ic= new CreateZip("prova");
	    ic.addFileToZip("/prova/", "p.txt", "cicixch");
	    ic.addFileToZip("/prova2/", "p.txt", "cicixch");
	    ic.addFileToZip("/prova/", "p2.txt", "cicixch2re");
	    
	    ic.createZip(response);
	}
}
