package com.example.drugcompare;

public class rxtermsProperties {
	private String brandName;
	private String displayName;
	private String synonym;
	private String fullName;
	private String fullGenericName;
	private String strength;
	private String genericName;
	private String rxtermsDoseForm;
	private String route;
	private String termType;
	private String rxcui;
	private String genericRxcui;
	private String rxnormDoseForm;
	private String suppress;
	
	
	public String getBrandName()
	{
		return brandName;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public String getSynonym()
	{
		return synonym;
	}
	
	public String getfullName()
	{
		return fullName;
	}
	
	public String getFullGenericName()
	{
		return fullGenericName;
	}
	
	public String getStrength()
	{
		return strength;
	}
	
	public String getGenericName()
	{
		return genericName;
	}
	
	public String getRXTermsDoseForm()
	{
		return rxtermsDoseForm;
	}
	
	public String getRoute()
	{
		return route;
	}
	
	public String getTermType()
	{
		return termType;
	}
	
	public String getRXCUI()
	{
		return rxcui;
	}
	
	public String getGenericRXCUI()
	{
		return genericRxcui;
	}
	
	public String getRXNormDoseForm()
	{
		return rxnormDoseForm;
	}
	
	public String getSuppress()
	{
		return suppress;
	}
	
	@Override
	public String toString(){
		return brandName + "\n" + displayName + "\n" + synonym + "\n" + fullName + "\n" + fullGenericName + "\n" + strength + "\n" + rxtermsDoseForm + "\n" + route + "\n" + termType + "\n" + rxcui + "\n" + genericRxcui + "\n" + rxnormDoseForm + "\n" + suppress;
	}

	

}
