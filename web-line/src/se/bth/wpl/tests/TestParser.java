package se.bth.wpl.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.bth.wpl.advcontentmkr.AdvContent;
import se.bth.wpl.advcontentmkr.IAdvContent;
import se.bth.wpl.filesystem.CreateZip;
import se.bth.wpl.filesystem.ICreateZip;
import se.bth.wpl.global.Global;
import se.bth.wpl.utils.Parser;
import se.bth.wpl.utils.ReadFiles;

@SuppressWarnings("serial")
public class TestParser extends HttpServlet{
    //private static final Logger log = Logger.getLogger(TestParser.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/zip");
	    response.setStatus(HttpServletResponse.SC_OK);
	    ICreateZip ic= new CreateZip("zipProva");
	    
	    Parser parser = new Parser();
	    ReadFiles rf = new ReadFiles();
	    /* HTML PARSER */
	    

	    String originalString = rf.readf(Global.getResPath(), "prova.txt");
	    String stringToZip="";
	    
	    stringToZip = parser.parse(originalString, "Titolo Di Prova", "provaTitle",Parser.REPLACE);
	    
		IAdvContent iacLike= new AdvContent();
		iacLike.addPlugin("FbLikePlugin", null);
	    stringToZip = parser.parse(stringToZip, iacLike.createAdvContent(), "provaFbLike",Parser.NEXTLINE);
	    	    
	    stringToZip = parser.parse(stringToZip,"<div id='provaIdDiv' style='background:#AA0000'>", "provaIdDiv",Parser.REPLACE_TILL_STOP);
	    
	    ic.addFileToZip("", "prova.htm", stringToZip);
	    
	    
	    /* CSS PARSER */
	    
	    String originalStrinCSS = rf.readf(Global.getResPath(), "prova.css");
	    String stringToZipCSS="";
	    stringToZipCSS = parser.parse(originalStrinCSS, "banana", "cssFont1",Parser.REPLACE_TILL_STOP);
	    stringToZipCSS = parser.parse(stringToZipCSS, "mela", "cssFont2",Parser.REPLACE_TILL_STOP);

	    ic.addFileToZip("", "prova.css", stringToZipCSS);


	    /* CREATE ZIP */
	    
	    ic.createZip(response);

	}

}
