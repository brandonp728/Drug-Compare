package com.example.floatingtest;

public class userInput {
	private String sources[];
	private String rxcui;
	
	public String[] getSources()
	{
		return sources;
	}
	
	public String getRXCUI()
	{
		return rxcui;
	}
	
	public String toString()
	{
		return "\nuserInput: "+sources[0] + " " + rxcui;
	}

}
