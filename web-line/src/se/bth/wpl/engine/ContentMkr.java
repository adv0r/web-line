package se.bth.wpl.engine;

import java.util.logging.Logger;

import se.bth.wpl.advcontentmkr.AdvContent;
import se.bth.wpl.advcontentmkr.IAdvContent;
import se.bth.wpl.global.Global;
import se.bth.wpl.model.CommonParams;
import se.bth.wpl.model.CompanyParams;
import se.bth.wpl.model.ParamsContainer;
import se.bth.wpl.model.PersonalParams;
import se.bth.wpl.utils.Parser;
import se.bth.wpl.utils.ReadFiles;


public class ContentMkr {
	
    private CompanyParams company_params;
    private CommonParams common_params;
    private PersonalParams personal_params;
    private ReadFiles rf;
    private Parser parser ;
    
    private final String CURRENT_PAGE_CLASS = "class='current_page_item' ";
    
    //COMMON
    private final String INDEX_PATH = Global.getPagesPath()+"_index.html";
    private final String ABOUT_PATH = Global.getPagesPath()+"_about.html";

    //COMPANY
    private final String PRODUCT1_PATH = Global.getPagesPath()+"_product1.html";
    private final String PRODUCT2_PATH = Global.getPagesPath()+"_product2.html";
    private final String PRODUCT3_PATH = Global.getPagesPath()+"_product3.html";

    private final String JOB_PATH = Global.getPagesPath()+"_job.html";
    private final String CONTACT_PATH_C = Global.getPagesPath()+"_contact_c.html";

    
    //PERSONAL
    private final String PORTFOLIO_HORIZONTAL_PATH = Global.getPagesPath()+"_portfolio_horizontal.html";
    private final String PORTFOLIO_VERTICAL_PATH = Global.getPagesPath()+"_portfolio_vertical.html";
    private final String CONTACT_PATH_P = Global.getPagesPath()+"_contact_p.html";


    //Logger
    private static final Logger log = Logger.getLogger(ContentMkr.class.getName());

	public ContentMkr(ParamsContainer pc) {
		this.common_params = pc.getCommon();
		this.personal_params = pc.getPersonal();
		this.company_params = pc.getCompany();
		
		rf= new ReadFiles();
		parser = new Parser();
	}

	public void createContent(){
		
		Global.setIndexContent(createIndexContent());
		Global.setIndex(createIndex(Global.getIndexContent()));
		
		Global.setAboutContent(createAboutContent());
		Global.setAbout(createAbout(Global.getAboutContent()));
		
		Global.setContactContent(createContactContent());
		Global.setContact(createContact(Global.getContactContent()));
		
		if(Global.isCompany())
		{
			Global.setJobContent(createJobContent());
			Global.setJob(createJob(Global.getJobContent()));
			if(company_params.isProductCheck()){
				Global.setProductContent(createProductContent());
				Global.setProduct(createProduct(Global.getProductContent()));
			}
		}
		else
		{
			if(personal_params.isPortfolioCheck()){
				Global.setPortfolioContent(createPortfolioContent());
				Global.setPortfolio(createPortfolio(Global.getPortfolioContent()));
			}
		}

		
	}

	/*---------- #### CREATE CONTENTS ##### ----------*/
	

	/* Create Portfolio Content */ 
	private String createPortfolioContent() {
		String toReturn="";
		log.warning("Generating Portfolio");
		
		if(personal_params.getPortRadio().equals("vertical"))
		{
			toReturn =  rf.readf(PORTFOLIO_VERTICAL_PATH);
		}
		else
		{
			toReturn = rf.readf(PORTFOLIO_HORIZONTAL_PATH);
		}
		return toReturn;
	}

	
	
	/* Create Product Content */ 
	private String createProductContent() {
		String toReturn ="";
		String prod = company_params.getProductRadio();
		if(prod.equals("1"))
		{
			 toReturn=rf.readf(PRODUCT1_PATH);
		}
		else if(prod.equals("2")){
			 toReturn=rf.readf(PRODUCT2_PATH);
		}
		else {
			 toReturn=rf.readf(PRODUCT3_PATH);
		}

		log.warning("Generating Product and Services");
		return toReturn;
	}
	
	
	/* Create Job Content */ 
	private String createJobContent() {
		String toReturn=rf.readf(JOB_PATH);
		
		/* One 
		 * <!--#WPL_ID='jobMail_a'-->
			<p><a href="mailto:<!--#WPL_ID='jobMail1'-->" class="ka_button small_button small_color_button" target=""><span>Apply</span></a><br />
			<!--STOP-->
		 
		 Two 
		 * <!--#WPL_ID='jobMail_b'-->
			<p><a href="mailto:<!--#WPL_ID='jobMail2'-->" class="ka_button small_button small_color_button" target=""><span>Apply</span></a><br />
			<!--STOP-->
			
 		Three 
		 * <!--#WPL_ID='jobMail_c'-->
			<p><a href="mailto:<!--#WPL_ID='jobMail3'-->" class="ka_button small_button small_color_button" target=""><span>Apply</span></a><br />
			<!--STOP-->
		 */
		if(company_params.isJobCheck())
		{
			toReturn = parser.parse(toReturn,"<p><a href='mailto:<!--#WPL_ID='jobMail1'-->' class='ka_button small_button small_color_button'><span>Apply</span></a><br />" , "jobMail_a",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, company_params.getJobMail(), "jobMail1",Parser.REPLACE);
			
			toReturn = parser.parse(toReturn,"<p><a href='mailto:<!--#WPL_ID='jobMail2'-->' class='ka_button small_button small_color_button'><span>Apply</span></a><br />" , "jobMail_b",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, company_params.getJobMail(), "jobMail2",Parser.REPLACE);
			
			toReturn = parser.parse(toReturn,"<p><a href='mailto:<!--#WPL_ID='jobMail3'-->' class='ka_button small_button small_color_button'><span>Apply</span></a><br />" , "jobMail_c",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, company_params.getJobMail(), "jobMail3",Parser.REPLACE);
		}
			
		log.warning("Generating Jobs");
		return toReturn;
	}

	
	/* Create Contact Content */ 
	private String createContactContent() {
		String toReturn="";
		if(Global.isCompany())
		{
			toReturn=rf.readf(CONTACT_PATH_C);
						
			/*
			<!--#WPL_ID='contactName'-->
			<!--#WPL_ID='contactEmail2'-->"
		    <!--#WPL_ID='contactEmail'-->
		    */
			toReturn = parser.parse(toReturn, common_params.getCname(), "contactName", Parser.REPLACE);
			toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail2", Parser.REPLACE);
			toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail", Parser.REPLACE);

			
			/*
			 * 		    <!--#WPL_ID='checkPhone'-->
		    <strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />
		    <!--STOP-->
			 */
			if(common_params.isCphoneCheck())
			{
				toReturn = parser.parse(toReturn,"<strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />" , "checkPhone",Parser.REPLACE_TILL_STOP);
				toReturn = parser.parse(toReturn, common_params.getCphoneValue(), "contactPhone", Parser.REPLACE);

			}
		    

		    /*		    
		     * <!--#WPL_ID='checkAddress'--> 
		    <strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />
		    <!--STOP--> 

		     */
			toReturn = parser.parse(toReturn,"<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />" , "checkAddress",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, company_params.getCaddressValue(), "contactAddress", Parser.REPLACE);

			
			/*
			 * 	<!--#WPL_ID='gMap'-->
		    <iframe width="350" height="170" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=425+main+street+forest+city+pa&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=41.360684,93.076172&amp;ie=UTF8&amp;hq=&amp;hnear=425+Main+St,+Forest+City,+Pennsylvania+18421&amp;z=14&amp;ll=41.633433,-75.469825&amp;output=embed"></iframe>
		    </div>
		    <!--STOP-->
			 */
			if(company_params.isMapCheckBox())
			{
				String[] params = {company_params.getCaddressValue().replace(" ", "+"),company_params.getCaddressValue().replace(" ", "+")};
				IAdvContent iacMap= new AdvContent();
				iacMap.addPlugin("MapPlugin", params);
				toReturn = parser.parse(toReturn, iacMap.createAdvContent(),"gMap",Parser.REPLACE_TILL_STOP);
			}
		    

		}
		else {
			//PERSONAL
			toReturn=rf.readf(CONTACT_PATH_P);
			/*
			<!--#WPL_ID='contactName'-->
			<!--#WPL_ID='contactEmail2'-->"
		    <!--#WPL_ID='contactEmail'-->
		    */
			toReturn = parser.parse(toReturn, common_params.getCname(), "contactName", Parser.REPLACE);
			toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail2", Parser.REPLACE);
			toReturn = parser.parse(toReturn, common_params.getCmail(), "contactEmail", Parser.REPLACE);

			
			/*
			 * 		    <!--#WPL_ID='checkPhone'-->
		    <strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />
		    <!--STOP-->
			 */
			if(common_params.isCphoneCheck())
			{
				toReturn = parser.parse(toReturn,"<strong>Phone number: </strong><!--#WPL_ID='contactPhone'--><br />" , "checkPhone",Parser.REPLACE_TILL_STOP);
				toReturn = parser.parse(toReturn, common_params.getCphoneValue(), "contactPhone", Parser.REPLACE);

			}
		    

		    /*		    
		     * <!--#WPL_ID='checkAddress'--> 
		    <strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />
		    <!--STOP--> 

		     */
			toReturn = parser.parse(toReturn,"<strong>Address: </strong><!--#WPL_ID='contactAddress'--><br />" , "checkAddress",Parser.REPLACE_TILL_STOP);
			toReturn = parser.parse(toReturn, personal_params.getPaddressValue(), "contactAddress", Parser.REPLACE);
			
		}
		log.warning("Generating Contact");
		return toReturn;
	}

	/* Create About Content */ 
	private String createAboutContent() {
		String toReturn=rf.readf(ABOUT_PATH);
		log.warning("Generating About");
		return toReturn;
	}
	
	
	/* Create Index Content */ 
	private String createIndexContent() {
		String toReturn=rf.readf(INDEX_PATH);
		log.warning("Generating Index");
		return toReturn;
	}

	
	/*---------- #### MERGE STRUCTURE WITH CODE ##### ----------*/

	
	private String createPortfolio(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		toReturn = parser.parse(toReturn, personal_params.getPortNameID()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);
		
		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mPortfolio", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mAbout", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mHome", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mContact", Parser.REPLACE);
		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);
	
		return toReturn;
	}

	private String createProduct(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		toReturn = parser.parse(toReturn, company_params.getProductNameID()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);

		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mProduct", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mAbout", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mHome", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mContact", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mJobs", Parser.REPLACE);		
		
		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);

		return toReturn;
	}

	private String createJob(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		toReturn = parser.parse(toReturn, company_params.getJobOfferTitle()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);

		
		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mJobs", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mAbout", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mHome", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mContact", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mProduct", Parser.REPLACE);

		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);

		return toReturn;
	}

	private String createContact(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		toReturn = parser.parse(toReturn, common_params.getContact_title()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);
		
		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mContact", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mAbout", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mHome", Parser.REPLACE);
		
		if(Global.isCompany())
		{
			toReturn = parser.parse(toReturn, "", "mJobs", Parser.REPLACE);
			if(company_params.isProductCheck())
				toReturn = parser.parse(toReturn, "", "mProduct", Parser.REPLACE);
		}
		else
		{
			if(personal_params.isPortfolioCheck())
				toReturn = parser.parse(toReturn, "", "mPortfolio", Parser.REPLACE);
		}
	
		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);
		
		return toReturn;
	}

	private String createAbout(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		
		toReturn = parser.parse(toReturn, common_params.getAbout_title()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);

		
		
		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mAbout", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mContact", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mHome", Parser.REPLACE);
		
		if(Global.isCompany())
		{
			toReturn = parser.parse(toReturn, "", "mJobs", Parser.REPLACE);
			if(company_params.isProductCheck())
				toReturn = parser.parse(toReturn, "", "mProduct", Parser.REPLACE);
		}
		else
		{
			if(personal_params.isPortfolioCheck())
				toReturn = parser.parse(toReturn, "", "mPortfolio", Parser.REPLACE);
		}
	
		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);

		
		return toReturn;
	}

	private String createIndex(String string) {
		String toReturn=Global.getStructure();
		String content = string;
		
		toReturn = parser.parse(toReturn, common_params.getHome_title()+" - "+common_params.getSitename(), "pageTitle", Parser.REPLACE);

		//Assign the class to the current
		toReturn = parser.parse(toReturn, CURRENT_PAGE_CLASS, "mHome", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mContact", Parser.REPLACE);
		toReturn = parser.parse(toReturn, "", "mAbout", Parser.REPLACE);
		
		if(Global.isCompany())
		{
			toReturn = parser.parse(toReturn, "", "mJobs", Parser.REPLACE);
			if(company_params.isProductCheck())
				toReturn = parser.parse(toReturn, "", "mProduct", Parser.REPLACE);
		}
		else
		{
			if(personal_params.isPortfolioCheck())
				toReturn = parser.parse(toReturn, "", "mPortfolio", Parser.REPLACE);
		}
		
		
		//Place the content!
		toReturn = parser.parse(toReturn, content, "mainContent", Parser.REPLACE);

		return toReturn;
	}

	

}
