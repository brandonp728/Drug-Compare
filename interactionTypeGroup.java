package com.example.drugcompare;

public class interactionTypeGroup {
	private String sourceDisclaimer;
	private String sourceName;
	private interactionType[] interactionType;
	
	public String getSourceDisclaimer()
	{
		return sourceDisclaimer;
	}
	
	public String getSourceName()
	{
		return sourceName;
	}
	
	public interactionType[] getInteractionType()
	{
		return interactionType;
	}
	
	public String toString()
	{
		return "\nInteraction Type Group: " +sourceDisclaimer + "\n" + sourceName + "\n" + interactionType[0];
	}
	

}
