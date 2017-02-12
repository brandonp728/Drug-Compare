package com.example.drugcompare;

public class minConceptItem {
	private String rxcui;
	private String name;
	private String tty;
	
	public String getRXCUI()
	{
		return rxcui;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTTY()
	{
		return tty;
	}
	
	public String toString()
	{
		return rxcui + " " + name + " " + tty;
	}

}
