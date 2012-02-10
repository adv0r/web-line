package se.bth.wpl.model;

public class CompanyParams {
	
	// ########      Company Parameters 

	
	private String colorCO;
	private String jobOfferTitle;
	private boolean jobCheck;
	private String jobMail;
	private boolean productCheck ;
	private String productNameID;
	private String productRadio ;
	private boolean fbSocial ;
	private String fbSocialUrl ;
	private boolean caddressCheck ;
	private String caddressValue ;
	private boolean mapCheckBox ;
	private boolean newsCheck ;
	private String newsButtonURL ;
	
	
	
	
	
	
	// ########      Constructor 

	
	public CompanyParams(String colorCO, String jobOfferTitle, String jobCheck,
			String jobMail, String productCheck, String productNameID,
			String productRadio, String fbSocial, String fbSocialUrl,
			String caddressCheck, String caddressValue, String mapCheckBox,
			String newsCheck, String newsButtonURL) {
		super();
		
		if(colorCO!=null)
			this.colorCO = colorCO;

		if(jobOfferTitle!="")
			this.jobOfferTitle = jobOfferTitle;
		else
			this.jobOfferTitle = "Job Offers";

		if(jobCheck!=null)
			this.jobCheck = true;
		else
			this.jobCheck = false;
		
		if(jobMail!=null)
			this.jobMail = jobMail;
		else
			this.jobMail = "jobs@example.com";
		
		if(productCheck!=null)
			this.productCheck = true;
		else 
			this.productCheck = false;
		
		if(productNameID!="")
			this.productNameID = productNameID;
		else
			this.productNameID = "Products and Services";
		
		if(productRadio!=null)
			this.productRadio = productRadio;
		else productRadio="3";
		
		if(fbSocial!=null)
			this.fbSocial = true;
		else 
			this.fbSocial = false;
		
		if(fbSocialUrl!=null)
			this.fbSocialUrl = fbSocialUrl;
		else
			this.fbSocialUrl = "http://www.facebook.com";
		
		if(caddressCheck!=null)
			this.caddressCheck = true;
		else
			this.caddressCheck = false;
		
		if(caddressValue!=null)
			this.caddressValue = caddressValue;
		else
			this.caddressValue = "";
		
		if(mapCheckBox!=null)
			this.mapCheckBox = true;
		else
			this.mapCheckBox = false;
		
		if(newsCheck!=null)
			this.newsCheck = true;
		else
			this.newsCheck = false;
		
		if(newsButtonURL!=null)
			this.newsButtonURL = newsButtonURL;
		else
			this.newsButtonURL = "http://www.example.com/news.rss";
	}
	
	
	// ########      Getters 

	public String getColorCO() {
		return colorCO;
	}


	public String getJobOfferTitle() {
		return jobOfferTitle;
	}


	public boolean isJobCheck() {
		return jobCheck;
	}

	public String getJobMail() {
		return jobMail;
	}

	public boolean isProductCheck() {
		return productCheck;
	}

	public String getProductNameID() {
		return productNameID;
	}
	public String getProductRadio() {
		return productRadio;
	}

	public boolean isFbSocial() {
		return fbSocial;
	}
	public String getFbSocialUrl() {
		return fbSocialUrl;
	}

	public boolean isCaddressCheck() {
		return caddressCheck;
	}

	public String getCaddressValue() {
		return caddressValue;
	}

	public boolean isMapCheckBox() {
		return mapCheckBox;
	}

	public boolean isNewsCheck() {
		return newsCheck;
	}

	public String getNewsButtonURL() {
		return newsButtonURL;
	}


	@Override
	public String toString() {
		return "CompanyParams [colorCO=" + colorCO + ", jobOfferTitle="
				+ jobOfferTitle + ", jobCheck=" + jobCheck + ", jobMail="
				+ jobMail + ", productCheck=" + productCheck
				+ ", productNameID=" + productNameID + ", productRadio="
				+ productRadio + ", fbSocial=" + fbSocial + ", fbSocialUrl="
				+ fbSocialUrl + ", caddressCheck=" + caddressCheck
				+ ", caddressValue=" + caddressValue + ", mapCheckBox="
				+ mapCheckBox + ", newsCheck=" + newsCheck + ", newsButtonURL="
				+ newsButtonURL + "]";
	}

	
	
}





