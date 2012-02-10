package se.bth.wpl.model;

public class PersonalParams {
	
	// ########      Personal Parameters 

	private boolean portfolioCheck ;
	private String portNameID ;
	private String portRadio ;
	private String colorPE ;
	private boolean paddressCheck;
	private String paddressValue;
	
	
	
	// ########      Constructor 

	public PersonalParams(String portfolioCheck, String portNameID,
			String portRadio, String colorPE, String paddressCheck,
			String paddressValue) {
		super();
		
		if(portfolioCheck!=null)
			this.portfolioCheck = true;
		else
			this.portfolioCheck = false;
		
		if(portNameID!=null)
			this.portNameID = portNameID;
		else
			this.portNameID = "Portfolio";
	
		this.portRadio = portRadio;
		this.colorPE = colorPE;
		
		if(paddressCheck!=null)
			this.paddressCheck = true;
		else 
			this.paddressCheck = false;
		
		if(paddressValue!=null)
			this.paddressValue = paddressValue;
		else
			this.paddressValue = "";
	}
	
	
	// ########      Getters 

	public boolean isPortfolioCheck() {
		return portfolioCheck;
	}

	public String getPortNameID() {
		return portNameID;
	}

	public String getPortRadio() {
		return portRadio;
	}

	public String getColorPE() {
		return colorPE;
	}

	public boolean isPaddressCheck() {
		return paddressCheck;
	}


	public String getPaddressValue() {
		return paddressValue;
	}


	@Override
	public String toString() {
		return "PersonalParams [portfolioCheck=" + portfolioCheck
				+ ", portNameID=" + portNameID + ", portRadio=" + portRadio
				+ ", colorPE=" + colorPE + ", paddressCheck=" + paddressCheck
				+ ", paddressValue=" + paddressValue + "]";
	}

	

}
