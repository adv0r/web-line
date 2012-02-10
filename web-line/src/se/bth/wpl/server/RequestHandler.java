package se.bth.wpl.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.*;

import se.bth.wpl.engine.ContentMkr;
import se.bth.wpl.engine.StructureMkr;
import se.bth.wpl.filesystem.CreateZip;
import se.bth.wpl.filesystem.ICreateZip;
import se.bth.wpl.global.Global;
import se.bth.wpl.model.CommonParams;
import se.bth.wpl.model.CompanyParams;
import se.bth.wpl.model.ParamsContainer;
import se.bth.wpl.model.PersonalParams;
import se.bth.wpl.utils.Parser;
import se.bth.wpl.utils.ReadFiles;
import se.bth.wpl.utils.SiteMapGenerator;


@SuppressWarnings("serial")
public class RequestHandler extends HttpServlet {
	CompanyParams companyParams;
	PersonalParams personalParams;
	CommonParams commonParams;

    private static final Logger log = Logger.getLogger(RequestHandler.class.getName());


    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    	throws IOException {
    	
          /* Set Response type */
    	  resp.setContentType("application/zip");
    	  resp.setStatus(HttpServletResponse.SC_OK);
          log.warning("Request received");  
          
          /* Read Common Parameters */
          readParameters(req);   	  
          log.warning("non-Common Param created");
    	  ParamsContainer pc = null;
    	  
          /* Read NON-Common Parameters */
    	  if(commonParams.getSite_type().equals(Global.getCompany()))
    	  {
    		  pc = new ParamsContainer(commonParams, companyParams);
    		  Global.setCompany(true);
    	  }
    	  else
    	  	{
    		  pc = new ParamsContainer(commonParams, personalParams);
    		  Global.setCompany(false);
    		}
          log.warning("ParamsContainer Created");

          /* Check input Datas */
    	  pc.CheckData();
          log.warning("Data checked");
   
          //log.warning(pc.toString());

          
          /* Create Structure */
          StructureMkr sm = new StructureMkr(pc);
          sm.createStructure();
          
          
          /* Create Content */
          ContentMkr cm = new ContentMkr(pc);
          cm.createContent();
          
          /* Edit CSS */
          Global.setCss(editCss());
          
          /* Generate Sitemap */
          SiteMapGenerator smg = new SiteMapGenerator();
          if(Global.isCompany())
          {
        	  Global.setSitemap(smg.generateSitemap(true, false, companyParams.isProductCheck())); 
          }
          else
          {
        	  Global.setSitemap(smg.generateSitemap(false, personalParams.isPortfolioCheck(), false)); 
          }
          log.warning("Sitemap = "+Global.getSitemap());

          
          
          
          /* Create zip */
          createZip(pc.getCommon().getSitename(),resp);
          
	}
    
    
 


private void createZip(String zipName, HttpServletResponse resp) {
	    ICreateZip ic= new CreateZip(zipName.trim().replace(" ", "_"));
	 
	    ic.addFolderToZip("resources/css", "res/resources/css"); 
	    ic.addFolderToZip("resources/images", "res/resources/images"); 
	    ic.addFolderToZip("resources/js", "res/resources/js"); 
	    
	    ic.addFileToZip("pages/", "index.html", Global.getIndex()); 
	    ic.addFileToZip("pages/", "about.html", Global.getAbout()); 
	    ic.addFileToZip("pages/", "contact.html", Global.getContact()); 
	    
	    ic.addFileToZip("resources/css/", "_style.css", Global.getCss()); 
	    
	    ic.addFileToZip("", "sitemap.xml", Global.getSitemap()); 
	    
	    ic.addImageToZip("/","favicon.ico","res/other","favicon.ico");


	    if(Global.isCompany())
	    {
		    ic.addFileToZip("pages/", "job.html", Global.getJob()); 
	    	if(companyParams.isProductCheck())
	    	    ic.addFileToZip("pages/", "product.html", Global.getProduct()); 
	    }
	    else
	    {
	    	if(personalParams.isPortfolioCheck()){
			    ic.addFileToZip("pages/", "portfolio.html", Global.getPortfolio()); 
	    	}	    	
	    }
 
	    try {
			ic.createZip(resp);
		} catch (IOException e) {
			log.warning(e.getMessage());
		}
		
	}



   private void readParameters(HttpServletRequest req)
    {
  	  // Read Common parameters
  	  String site_type = req.getParameter("site_type");
  	  String sitename =  req.getParameter("sitename");
  	  String footernote =  req.getParameter("footernote");
  	  String font =  req.getParameter("font");
  	  String home_title =  req.getParameter("home_title");
  	  String contact_title =  req.getParameter("contact_title");
  	  String about_title =  req.getParameter("about_title");
  	  String fbLikeButton =  req.getParameter("fbLikeButton");
  	  String rtwBtnCheck =  req.getParameter("rtwBtnCheck");
  	  String retwButtonURL =  req.getParameter("retwButtonURL");
  	  String twIcon =  req.getParameter("twIcon");
  	  String twButtonURL =  req.getParameter("twButtonURL");
  	  String ldIcon =  req.getParameter("ldIcon");
  	  String ldButtonURL =  req.getParameter("ldButtonURL");
  	  String gplusIcon =  req.getParameter("gplusIcon");
  	  String digIcon =  req.getParameter("digIcon");
  	  String cname =  req.getParameter("cname");
  	  String cmail =  req.getParameter("cmail");
  	  String cphoneCheck =  req.getParameter("cphoneCheck");
  	  String cphoneValue =  req.getParameter("cphoneValue");
  	  String jqueryCheck =  req.getParameter("jqueryCheck");
  	  String ganalytics =  req.getParameter("ganalytics");
  	  String ganID =  req.getParameter("ganID");
  	  String gplusButtonURL = req.getParameter("gplusButtonURL");
  	 
  	  //Fill cp
  	  commonParams = new CommonParams(site_type,sitename,footernote,font,home_title,contact_title,about_title,
  			  fbLikeButton,rtwBtnCheck,retwButtonURL,twIcon,twButtonURL,ldIcon,ldButtonURL,gplusIcon,digIcon,
  			  cname,cmail,cphoneCheck,cphoneValue,jqueryCheck,ganalytics,ganID,gplusButtonURL);
        log.warning("Common Param created");

  	      

  	  if(site_type.equals(Global.getCompany()))
  	  {
  		 //Read parameters for COMPANY website
  		 String colorCO =  req.getParameter("colorCO");
  		 String jobOfferTitle =  req.getParameter("jobOfferTitle");
  		 String jobCheck =  req.getParameter("jobCheck");
  		 String jobMail =  req.getParameter("jobMail");
  		 String productCheck =  req.getParameter("productCheck");
  		 String productNameID =  req.getParameter("productNameID");
  		 String productRadio =  req.getParameter("productRadio");
  		 String fbSocial =  req.getParameter("fbSocial");
  		 String fbSocialUrl =  req.getParameter("fbSocialUrl");
  		 String caddressCheck =  req.getParameter("caddressCheck");
  		 String caddressValue =  req.getParameter("caddressValue");
  		 String mapCheckBox =  req.getParameter("mapCheckBox");
  		 String newsCheck =  req.getParameter("newsCheck");
  		 String newsButtonURL =  req.getParameter("newsButtonURL");
  		 
  		 //Fill ncp
  		 companyParams = new CompanyParams(colorCO,jobOfferTitle,jobCheck,jobMail,productCheck,productNameID,
  				 productRadio,fbSocial,fbSocialUrl,caddressCheck,caddressValue,mapCheckBox,
  				 newsCheck,newsButtonURL);
  	  }
  	  
  	  else
  	  {
  		 //Read parameters for PERSONAL website  
  		 String portfolioCheck =  req.getParameter("portfolioCheck");
  		 String portNameID =  req.getParameter("portNameID");
  		 String portRadio =  req.getParameter("portRadio");
  		 String colorPE =  req.getParameter("colorPE");
  		 String paddressCheck =  req.getParameter("paddressCheck");
  		 String paddressValue =  req.getParameter("paddressValue");
      		 
  		 //Fill ncp
  		 personalParams = new PersonalParams(portfolioCheck,portNameID,portRadio,colorPE,paddressCheck,paddressValue);

  	  }
    	
    }
   
   
   private String editCss() {
		
		 ReadFiles reF = new ReadFiles();
		 Parser p = new Parser();
		 String css = reF.readf(Global.getResPath()+"other/_style.css");
		 
		 if(commonParams.getFont().equals("verdana"))
		 {
			 css =	p.parse(css, "Verdana,Arial,Times", "cssFont1", Parser.REPLACE_TILL_STOP) ;
			 css =	p.parse(css, "Verdana,Arial,Times", "cssFont2", Parser.REPLACE_TILL_STOP) ;

		 }
		 else if(commonParams.getFont().equals("arial"))
		 {
			 css =	p.parse(css, "Arial,Verdana,Times", "cssFont1", Parser.REPLACE_TILL_STOP) ;
			 css =	p.parse(css, "Arial,Verdana,Times", "cssFont2", Parser.REPLACE_TILL_STOP) ;


		 }
		 else //TIMEs
		 {
			 css =	p.parse(css, "Times,Arial,Verdana", "cssFont1", Parser.REPLACE_TILL_STOP) ;
			 css =	p.parse(css, "Times,Arial,Verdana", "cssFont2", Parser.REPLACE_TILL_STOP) ;
		 }
		return css;
		
		}

}
