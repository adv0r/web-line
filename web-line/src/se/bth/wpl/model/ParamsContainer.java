package se.bth.wpl.model;

public class ParamsContainer {

	
	private CommonParams common;
	private CompanyParams company;
	private PersonalParams personal;
	private boolean isCompany;

	
	public ParamsContainer(CommonParams common,CompanyParams company )
	{
		this.common = common;
		this.company = company;
		this.personal = null;
		this.isCompany = true;
		
	}
	
	
	
	
	public ParamsContainer(CommonParams common,PersonalParams personal)
	{
		this.common = common;
		this.personal = personal;
		this.company = null;
		this.isCompany = false;

	}
	
	
	
	public boolean isPersonal()
	{
		return !isCompany; 
	}

	public void CheckData() {

		
	}
	
	public CommonParams getCommon() {
		return common;
	}

	public CompanyParams getCompany() {
		return company;
	}
	
	public PersonalParams getPersonal() {
		return personal;
	}
	
	public String toString ()
	{
		String toReturn =common.toString();
		if(this.isPersonal())
			toReturn += this.personal;
		else 
			toReturn += this.company ;
		
		return toReturn;
	}



}
