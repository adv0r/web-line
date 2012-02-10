package se.bth.wpl.global;


public class Global {
	
	/* Strings */    
	private static final String APP_NAME = "Webline" ;
	private static final String APP_VERSION = "0.2";

	private static final String COMPANY = "company";
	private static final String PERSONAL = "personal";
	
	/* INTERNAL PATHS */
	private static final String RES_PATH = "res/";
	
	private static final String PAGES_PATH = "res/pages/";
	
	
	/* STRUCTURE */
	
	private static String Structure = "";
	
	
	/* CONTENT */
	
	private static String portfolioContent = "";
	private static String productContent = "";
	private static String jobContent = "";
	private static String indexContent = "";
	private static String aboutContent = "";
	private static String contactContent = "";
	
	/* FINAL */
	
	private static String Portfolio = "";
	private static String Product = "";
	private static String Job = "";
	private static String Index = "";
	private static String About = "";
	private static String Contact = "";


	
	/* PAGE CONTENTS */


	/* PRODUCT PATHS */

	private static final String PROD_RES_PATH = "resources/";
	private static final String PROD_PAGES_PATH = "pages/";
	
	
	private static final String PROD_IMG_PATH = PROD_RES_PATH+"img/";
	private static final String PROD_CSS_PATH = PROD_RES_PATH+"css/";
	private static final String PROD_JS_PATH = PROD_RES_PATH+"js/";
	
	private static boolean isCompany;

	private static String css ;
	private static String sitemap ;

	// # METHODS #
	
	public static boolean isCompany()
	{
		return isCompany;	
	}
	
	public static void setCompany(boolean company)
	{
		Global.isCompany = company;	
	}
	
	// # GETTERS # 
	
	
	
	public static String getResPath() {
		return RES_PATH;
	}
	public static String getProdPagesPath() {
		return PROD_PAGES_PATH;
	}
	public static String getProdImgPath() {
		return PROD_IMG_PATH;
	}
	public static String getProdCssPath() {
		return PROD_CSS_PATH;
	}
	public static String getProdJsPath() {
		return PROD_JS_PATH;
	}
	public static String getProdResPath() {
		return PROD_RES_PATH;
	}
	public static String getAppName() {
		return APP_NAME;
	}
	public static String getAppVersion() {
		return APP_VERSION;
	}
	public static String getCompany() {
		return COMPANY;
	}
	public static String getPersonal() {
		return PERSONAL;
	}
	
	public static String getPagesPath() {
		return PAGES_PATH;
	}

	public static String getStructure() {
		return Structure;
	}

	public static String getPortfolio() {
		return Portfolio;
	}

	public static String getProduct() {
		return Product;
	}

	public static String getJob() {
		return Job;
	}

	public static String getIndex() {
		return Index;
	}

	public static String getAbout() {
		return About;
	}

	public static String getContact() {
		return Contact;
	}

	public static void setStructure(String structure) {
		Structure = structure;
	}

	public static void setPortfolio(String portfolio) {
		Portfolio = portfolio;
	}

	public static void setProduct(String product) {
		Product = product;
	}

	public static void setJob(String job) {
		Job = job;
	}

	public static void setIndex(String index) {
		Index = index;
	}

	public static void setAbout(String about) {
		About = about;
	}

	public static void setContact(String contact) {
		Contact = contact;
	}

	public static String getPortfolioContent() {
		return portfolioContent;
	}

	public static String getProductContent() {
		return productContent;
	}

	public static String getJobContent() {
		return jobContent;
	}

	public static String getIndexContent() {
		return indexContent;
	}

	public static String getAboutContent() {
		return aboutContent;
	}

	public static String getContactContent() {
		return contactContent;
	}

	public static void setPortfolioContent(String portfolioContent) {
		Global.portfolioContent = portfolioContent;
	}

	public static void setProductContent(String productContent) {
		Global.productContent = productContent;
	}

	public static void setJobContent(String jobContent) {
		Global.jobContent = jobContent;
	}

	public static void setIndexContent(String indexContent) {
		Global.indexContent = indexContent;
	}

	public static void setAboutContent(String aboutContent) {
		Global.aboutContent = aboutContent;
	}

	public static void setContactContent(String contactContent) {
		Global.contactContent = contactContent;
	}

	public static String getCss() {
		return css;
	}

	public static void setCss(String css) {
		Global.css = css;
	}

	public static String getSitemap() {
		return sitemap;
	}

	public static void setSitemap(String sitemap) {
		Global.sitemap = sitemap;
	}
	
	
	
	

}
