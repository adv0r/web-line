package se.bth.wpl.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.bth.wpl.filesystem.CreateZip;
import se.bth.wpl.filesystem.ICreateZip;
import se.bth.wpl.utils.ReadFiles;



@SuppressWarnings("serial")
public class TestServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // ..... process request

	    // ..... then respond
	    response.setContentType("application/zip");
	    response.setStatus(HttpServletResponse.SC_OK);
	    ICreateZip ic= new CreateZip("prova");
	    ReadFiles rf= new ReadFiles();
	    String tmp= rf.readf("res/","prova.txt");
	    ic.addFileToZip("/prova/", "p.txt",tmp);
	   
	    
	    ic.createZip(response);
	}
}
