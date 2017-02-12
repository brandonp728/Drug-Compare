package com.example.drugcompare;

public class interactionType {
	private String comment;
	private minConceptItem minConceptItem;
	private interactionPair[] interactionPair;
	
	
	public interactionPair[] getInteractionPair()
	{
		return interactionPair;
	}
	
	public minConceptItem getMinConceptItem()
	{
		return minConceptItem;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public String toString()
	{
		return "\nInteraction Type: "+comment + " " + minConceptItem.toString() + " " + interactionPair[0];
	}

}
