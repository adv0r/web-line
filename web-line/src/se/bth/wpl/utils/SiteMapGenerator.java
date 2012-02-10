package se.bth.wpl.utils;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public  class SiteMapGenerator {
	Document dom;
	final Logger log = Logger.getLogger(SiteMapGenerator.class.getName());
	public String generateSitemap (boolean isCompany, boolean hasPortfolio,boolean hasProductAndServices){
		String suff="www.example.com/";
		ArrayList<String>p= new ArrayList<String>();
		p.add(suff+"index");
		p.add(suff+"about");
		p.add(suff+"contact");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
//		System.out.println(dateFormat.format(cal.getTime()));
		String toReturn="";
		String date= dateFormat.format(cal.getTime());
		if(isCompany){
			p.add(suff+"job");
			if(hasProductAndServices)
				p.add(suff+"product");
			toReturn=generateXML(p.iterator(), date, "daily", "0.8");
		}
		else{
			
			if(hasPortfolio){
				p.add(suff+"portfolio");
		}	
			toReturn=generateXML(p.iterator(), date, "monthly", "0.5");
		}
//		System.out.println(toReturn);
		return toReturn;
	}
	private String generateXML(Iterator<String> pages, String date, String freq, String prt){
		try {
			/////////////////////////////
			//Creating an empty XML Document

			//We need a Document
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			////////////////////////
			//Creating the XML tree

			//create the root element and add it to the document


			//create a comment and put it in the root element
			
			

			//create child element, add an attribute, and add to root
			Element urlset = doc.createElement("urlset");
			
			urlset.setAttribute("xmlns", "http://www.sitemaps.org/schemas/sitemap/0.9");
			doc.appendChild(urlset);
			Comment comment = doc.createComment("webline pages sitemap");
			urlset.appendChild(comment);
			Text text;
			while(pages.hasNext()){
				Element url = doc.createElement("url");  
				urlset.appendChild(url);
				//add a text element to the child

				Element loc = doc.createElement("loc");  
				url.appendChild(loc);

				text = doc.createTextNode(pages.next());
				loc.appendChild(text);

				Element lastmod = doc.createElement("lastmod");  
				url.appendChild(lastmod);

				text = doc.createTextNode(date);
				lastmod.appendChild(text);

				Element changefreq = doc.createElement("changefreq");  
				url.appendChild(changefreq);

				text = doc.createTextNode(freq);
				changefreq.appendChild(text);

				Element priority = doc.createElement("priority");  
				url.appendChild(priority);

				text = doc.createTextNode(prt);
				priority.appendChild(text);
			}


			/////////////////
			//Output the XML

			//set up a transformer
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			
			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString();
			log.warning(xmlString);
			//print xml
			return xmlString;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
