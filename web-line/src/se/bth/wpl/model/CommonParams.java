package se.bth.wpl.model;

import se.bth.wpl.global.Global;

public class CommonParams {

	
	// ########      Common Parameters 
	
	  private String site_type ;
	  private String sitename ;
	  private String footernote ;
	  private String font ;
	  private String home_title ;
	  private String contact_title ;
	  private String about_title ;
	  private boolean fbLikeButton ; 
	  private boolean rtwBtnCheck ; 
	  private String retwButtonURL ;
	  private boolean twIcon ; 
	  private String twButtonURL;
	  private boolean ldIcon ; 
	  private String ldButtonURL ;
	  private boolean gplusIcon; 
	  private boolean digIcon ; 
	  private String cname;
	  private String cmail;
	  private boolean cphoneCheck; 
	  private String cphoneValue;
	  private boolean jqueryCheck; 
	  private boolean ganalytics; 
	  private String ganID;
	  private String gplusButtonURL;
	  
	  
	  
	// ########      Constructor 
	  
	public CommonParams(String site_type, String sitename, String footernote,
			String font, String home_title, String contact_title,
			String about_title, String fbLikeButton, String rtwBtnCheck,
			String retwButtonURL, String twIcon, String twButtonURL,
			String ldIcon, String ldButtonURL, String gplusIcon,
			String digIcon, String cname, String cmail, String cphoneCheck,
			String cphoneValue, String jqueryCheck, String ganalytics,
			String ganID,String gplusButtonURL) {
		super();
		

		this.site_type = site_type;
	
		if(sitename!="")
			this.sitename = sitename;
		else
			this.sitename ="Site name";
		
		if(footernote!="")
			this.footernote = footernote;
		else
			this.footernote = "I didn t had time to write a disclaimer.";
	
		this.font = font;
			
		if(home_title!="")
			this.home_title = home_title;
		else
			this.home_title = "Home Page";
			
		if(contact_title!="")
			this.contact_title = contact_title;
		else
			this.contact_title = "Contact";
			
		if(about_title!="")
			this.about_title = about_title;
		else
			{
				if(site_type.equals(Global.getCompany()))
					this.about_title = "About us";
				else 
					this.about_title = "About me";
			}
			
		if(fbLikeButton!=null)
			this.fbLikeButton = true;
		else
			this.fbLikeButton = false;
			
		if(rtwBtnCheck!=null)
			this.rtwBtnCheck = true;
		else
			this.rtwBtnCheck = false;
			
		if(retwButtonURL!=null)
			this.retwButtonURL = retwButtonURL;
		else
			this.retwButtonURL = "";
		
		if(twIcon!=null)
			this.twIcon = true;
		else
			this.twIcon = false;
		
		if(twButtonURL!=null)
			this.twButtonURL = twButtonURL;
		else
			this.twButtonURL = "www.twitter.com";
		
		if(ldIcon!=null)
			this.ldIcon = true;
		else
			this.ldIcon = false;
		
		if(ldButtonURL!=null)
			this.ldButtonURL = ldButtonURL;
		else
			this.ldButtonURL = "http://www.linkedin.com";
		
		if(gplusIcon!=null)
			this.gplusIcon = true;
		else
			this.gplusIcon = false;
		
		if(gplusButtonURL!=null)
			this.gplusButtonURL = gplusButtonURL;
		else
			this.gplusButtonURL = "http://plus.google.com";
		
		if(digIcon!=null)
			this.digIcon = true;
		else
			this.digIcon = false;
		
		if(cname!="")
			this.cname = cname;
		else
			this.cname = "";
		
		if(cmail!="")
			this.cmail = cmail;
		else
			this.cmail = "";
		
		if(cphoneCheck!=null)
			this.cphoneCheck = true;
		else
			this.cphoneCheck = false;
		
		if(cphoneValue!=null)
			this.cphoneValue = cphoneValue;
		else
			this.cphoneValue = "";

		if(jqueryCheck!=null)
			this.jqueryCheck = true;
		else
			this.jqueryCheck = false;
		
		if(ganalytics!=null)
			this.ganalytics = true;
		else
			this.ganalytics = false;

		if(ganID!=null)
			this.ganID = ganID;
		else
			this.ganID = "XXXXXXXXX";

	}
	
	
	// ########      Getters 
	
	  public String getSite_type() {
			return site_type;
		}

		public String getSitename() {
			return sitename;
		}

		public String getFooternote() {
			return footernote;
		}

		public String getFont() {
			return font;
		}

		public String getHome_title() {
			return home_title;
		}

		public String getContact_title() {
			return contact_title;
		}

		public String getAbout_title() {
			return about_title;
		}

		public boolean isFbLikeButton() {
			return fbLikeButton;
		}


		public boolean isRtwBtnCheck() {
			return rtwBtnCheck;
		}


		public String getRetwButtonURL() {
			return retwButtonURL;
		}


		public boolean isTwIcon() {
			return twIcon;
		}


		public String getTwButtonURL() {
			return twButtonURL;
		}


		public boolean isLdIcon() {
			return ldIcon;
		}

		public String getLdButtonURL() {
			return ldButtonURL;
		}

		public boolean isGplusIcon() {
			return gplusIcon;
		}

		public boolean isDigIcon() {
			return digIcon;
		}


		public String getCname() {
			return cname;
		}

		public String getCmail() {
			return cmail;
		}


		public boolean isCphoneCheck() {
			return cphoneCheck;
		}

		public String getCphoneValue() {
			return cphoneValue;
		}

		public boolean isJqueryCheck() {
			return jqueryCheck;
		}


		public boolean isGanalytics() {
			return ganalytics;
		}


		public String getGanID() {
			return ganID;
		}

		
		  public String getGplusButtonURL() {
			return gplusButtonURL;
		}


		@Override
			public String toString() {
				return "CommonParams [site_type=" + site_type + ", sitename="
						+ sitename + ", footernote=" + footernote + ", font=" + font
						+ ", home_title=" + home_title + ", contact_title="
						+ contact_title + ", about_title=" + about_title
						+ ", fbLikeButton=" + fbLikeButton + ", rtwBtnCheck="
						+ rtwBtnCheck + ", retwButtonURL=" + retwButtonURL
						+ ", twIcon=" + twIcon + ", twButtonURL=" + twButtonURL
						+ ", ldIcon=" + ldIcon + ", ldButtonURL=" + ldButtonURL
						+ ", gplusIcon=" + gplusIcon + ", digIcon=" + digIcon
						+ ", cname=" + cname + ", cmail=" + cmail + ", cphoneCheck="
						+ cphoneCheck + ", cphoneValue=" + cphoneValue
						+ ", jqueryCheck=" + jqueryCheck + ", ganalytics=" + ganalytics
						+ ", ganID=" + ganID + ", gplusButtonURL=" + gplusButtonURL+"]";
			}

	
}
