package se.bth.wpl.engine;


import se.bth.wpl.advcontentmkr.AdvContent;
import se.bth.wpl.advcontentmkr.IAdvContent;
import se.bth.wpl.global.Global;
import se.bth.wpl.model.CommonParams;
import se.bth.wpl.model.CompanyParams;
import se.bth.wpl.model.ParamsContainer;
import se.bth.wpl.model.PersonalParams;
import se.bth.wpl.utils.Parser;
import se.bth.wpl.utils.ReadFiles;

public class StructureMkr {
	
    //private static final Logger log = Logger.getLogger(StructureMkr.class.getName());

	private final String TEMPLATE_C = "_template_c.html";
	private final String TEMPLATE_P = "_template_p.html";
    private CompanyParams company_params;
    private CommonParams common_params;
    private PersonalParams personal_params;

	public StructureMkr(ParamsContainer pc){
		this.common_params = pc.getCommon();
		this.personal_params = pc.getPersonal();
		this.company_params = pc.getCompany();
	}
	
	public void createStructure()
	{
		String template = readTemplate();
		template = applyChanges(template);
		Global.setStructure(template);
	}


	private String applyChanges(String template) {
		String toReturn = template;
	    Parser parser = new Parser();
	    
	    
	    //Common Structure  
	    
	    /*Insert jQuery when necessary */ 	//<!--#WPL_ID='jQuery'-->
		if(common_params.isJqueryCheck())
		{	/*
			GenericPlugin jquery = new JqueryPlugin(null, "jQuery");
			toReturn = parser.parse(toReturn, jquery.generateCode(), jquery.getPositionID(),Parser.REPLACE);
			*/
			IAdvContent iacJqyery= new AdvContent();
			iacJqyery.addPlugin("JqueryPlugin", null);
			toReturn = parser.parse(toReturn,iacJqyery.createAdvContent(), "jQuery",Parser.REPLACE);
		}
			
		/* Contact Name 
		 * <strong>Name: </strong> <!--#WPL_ID='contactName'--><br />
		 */
		toReturn = parser.parse(toReturn, common_params.getCname(), "contactName",Parser.REPLACE);

			
		/* Contact Email 
		 * <strong>Email: </strong><a href="mailto:<!--#WPL_ID='contactEmail2'-->"><!--#WPL_ID='contactEmail'--></a><br />
		 */
		toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail",Parser.REPLACE);
		toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail2",Parser.REPLACE);

		
		/* Contact Phone
		 *  <!--#WPL_ID='checkPhone'-->
		    <strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />
		    <!--STOP-->
		 */
		if(common_params.isCphoneCheck())
		{
			toReturn = parser.parse(toReturn,"<strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />" , "checkPhone",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, common_params.getCphoneValue(), "contactPhone",Parser.REPLACE);
		}
		   

		
		/* Digg
		 *<!--#WPL_ID='digg'-->
		 *<!--STOP-->
	     */	
		if(common_params.isDigIcon())
		{
			IAdvContent iacDigg= new AdvContent();
			iacDigg.addPlugin("DiggPlugin", null);
			toReturn = parser.parse(toReturn, iacDigg.createAdvContent(), "digg",Parser.REPLACE_TILL_STOP);

		}
			
		
		/* ReTweet
		 * <!--#WPL_ID='reTweet'-->
		   <!--STOP-->
		 */		
		if(common_params.isRtwBtnCheck())
		{
			String[] params = {common_params.getRetwButtonURL()};
			IAdvContent iacRtwt= new AdvContent();
			iacRtwt.addPlugin("ReTweetPlugin", params);
			toReturn = parser.parse(toReturn, iacRtwt.createAdvContent(),"reTweet",Parser.REPLACE_TILL_STOP);
		}
		
		
		/* Twitter
		 * <!--#WPL_ID='twitter'-->
		 * <!--STOP-->
		 */
		if(common_params.isTwIcon())
		{
			String[] params = {common_params.getTwButtonURL()};
			IAdvContent iacTweet= new AdvContent();
			iacTweet.addPlugin("TwitterPlugin", params);
			toReturn = parser.parse(toReturn, iacTweet.createAdvContent(), "twitter",Parser.REPLACE_TILL_STOP);
		}
		
		/* Linkedin
		 * <!--#WPL_ID='LinkedIn'-->
		 * <!--STOP-->
		 */
		if(common_params.isLdIcon())
		{
			String[] params = {common_params.getLdButtonURL()};
			IAdvContent iacLinkedin= new AdvContent();
			iacLinkedin.addPlugin("LinkedInPlugin", params);
			toReturn = parser.parse(toReturn, iacLinkedin.createAdvContent(), "LinkedIn",Parser.REPLACE_TILL_STOP);
		}
			
		/* G+
		 * <!--#WPL_ID='googlePlus'-->
		 * <!--STOP-->
		 */	
		if(common_params.isGplusIcon())
		{
			String[] params = {common_params.getGplusButtonURL()};
			IAdvContent iacGooglePlus= new AdvContent();
			iacGooglePlus.addPlugin("GoogleplusPlugin", params);
			toReturn = parser.parse(toReturn, iacGooglePlus.createAdvContent(), "googlePlus",Parser.REPLACE_TILL_STOP);
		}
	
		
		/* Facebook Like Button 
		 * <!--#WPL_ID='fbLike'-->
		 * <!--STOP-->
		 */
		if(common_params.isFbLikeButton())
		{
		    IAdvContent iacLike= new AdvContent();
		    iacLike.addPlugin("FbLikePlugin", null);
		    toReturn = parser.parse(toReturn, iacLike.createAdvContent(), "fbLike",Parser.REPLACE_TILL_STOP);
		}
			
		/* Foot note
		 * <div id="foot_left"><p><!--#WPL_ID='footNote'-->Copyright &copy; 2011 WEBLINE. All rights reserved.<!--STOP--></p>
		 */
		toReturn = parser.parse(toReturn, common_params.getFooternote(), "footNote",Parser.REPLACE_TILL_STOP);

			
		/* Google Analytics
		 * <!--#WPL_ID='googleAnalytic'-->
		 */
		if(common_params.isGanalytics())
		{
			String[] params = {common_params.getGanID()};
			IAdvContent iacAnalytics= new AdvContent();
			iacAnalytics.addPlugin("AnalyticsPlugin", params);
			toReturn = parser.parse(toReturn, iacAnalytics.createAdvContent(), "googleAnalytic",Parser.REPLACE);
		}
		
		/* Website Name 
		 * <p><!--#WPL_ID='websiteName'--></p> */	
		toReturn = parser.parse(toReturn, common_params.getSitename(), "websiteName",Parser.REPLACE);
		
		
	    
		if(Global.isCompany())
		{
		// Company Structure Maker--------------------------------------------------------------------------------
			
			
			/* Background Color 
			* <link href="../resources/css/<!--#WPL_ID='colorCSS'-->.css" rel="stylesheet" type="text/css" /> 
			*/
			if(company_params.getColorCO().equals("black"))
			{
				toReturn = parser.parse(toReturn, "black", "colorCSS",Parser.REPLACE);
			}
			else //lightblue
			{
				toReturn = parser.parse(toReturn, "blue", "colorCSS",Parser.REPLACE);
			}
			
			

			/* News Ticker 
			 * <!--#WPL_ID='newsTicker'-->
			 */
			if(Global.isCompany())
			{	
				if(company_params.isNewsCheck())
				{
					String[] params = {company_params.getNewsButtonURL()};
					IAdvContent iacTicker= new AdvContent();
					iacTicker.addPlugin("NewsPlugin", params);
					toReturn = parser.parse(toReturn, iacTicker.createAdvContent(),"newsTicker",Parser.REPLACE);
				}
			}
			
				
			
			
			/* Facebook Social Plugin
			 * <!--#WPL_ID='fbSocial'--> 
			 */
			if(company_params.isFbSocial())
			{	
				String[] params = {company_params.getFbSocialUrl()};
				IAdvContent iacSocial= new AdvContent();
				iacSocial.addPlugin("FbSocialPlugin", params);
				toReturn = parser.parse(toReturn, iacSocial.createAdvContent(), "fbSocial",Parser.REPLACE);
			}
			
			

			/* Contact Address
			 * <!--#WPL_ID='checkAddress'--> 
	    		<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />
	    		<!--STOP--> 
			 */
	
				if(company_params.isCaddressCheck())
				{
					toReturn = parser.parse(toReturn,"<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />" , "checkAddress",Parser.REPLACE_TILL_STOP);
					toReturn = parser.parse(toReturn, company_params.getCaddressValue(), "contactAddress",Parser.REPLACE);
				}
			
			
			/* Menu entry : Product and Services */
			if(company_params.isProductCheck())
			{
				toReturn = parser.parse(toReturn,"<li  <!--#WPL_ID='mProduct'--> ><a href='product.html' ><span>PRODUCT & SERVICE</span></a></li>" , "productService",Parser.REPLACE_TILL_STOP);

			}
 
			
			
		}
		else
		{
			// Personal Structure Maker	------------------------------------------------------------------
			
			/* Background Color 
			* <link href="../resources/css/<!--#WPL_ID='colorCSS'-->.css" rel="stylesheet" type="text/css" /> 
			*/
			if(personal_params.getColorPE().equals("black"))
			{
				toReturn = parser.parse(toReturn, "black", "colorCSS",Parser.REPLACE);
			}
			else if (personal_params.getColorPE().equals("lightblue"))//lightblue
			{
				toReturn = parser.parse(toReturn, "blue", "colorCSS",Parser.REPLACE);
			}
			else //pink
				toReturn = parser.parse(toReturn, "pink", "colorCSS",Parser.REPLACE);
			
				
			
			/* Contact Address
			 * <!--#WPL_ID='checkAddress'--> 
	    		<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />
	    		<!--STOP--> 
			 */
			if(personal_params.isPaddressCheck())
			{
				toReturn = parser.parse(toReturn,"<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />" , "checkAddress",Parser.REPLACE_TILL_STOP);
				toReturn = parser.parse(toReturn, personal_params.getPaddressValue(), "contactAddress",Parser.REPLACE);
			}
			
			
			

			/* Menu entry : Portfolio */
			if(personal_params.isPortfolioCheck())
			{
				toReturn = parser.parse(toReturn,"<li <!--#WPL_ID='mPortfolio'-->><a href='portfolio.html'  ><span>PORTFOLIO</span></a></li>" , "portfolio",Parser.REPLACE_TILL_STOP);
			}

		}
		return toReturn;
	}

	private String readTemplate() {
		String toReturn="";
		ReadFiles rf = new ReadFiles();
		if(Global.isCompany())
		{
			toReturn = rf.readf(Global.getPagesPath(), TEMPLATE_C);
		}
		else {
			toReturn = rf.readf(Global.getPagesPath(), TEMPLATE_P);		
		}
		return toReturn;
	}

}
