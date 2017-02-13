package com.example.floatingtest;

public class drugRelationship {
	private String nlmDisclaimer;
	private userInput userInput;
	private interactionTypeGroup[] interactionTypeGroup;
	
	
	
	public userInput getUserInput()
	{
		return userInput;
	}
	
	public interactionTypeGroup[] getTypeGroup()
	{
		return interactionTypeGroup;
	}
	
	public String getDisclaimer()
	{
		return nlmDisclaimer;
	}
	
	public String toString()
	{
		return "\nDrug relationship: " + nlmDisclaimer + "\n" + userInput + "\n" + interactionTypeGroup[0] + "\n";
	}

}
