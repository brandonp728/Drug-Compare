package com.example.floatingtest;

public class interactionPair {
	private interactionConcept[] interactionConcept;
	private String severity;
	private String description;
	
	
	public String getDescription()
	{
		return description;
	}
	
	public String getSeverity()
	{
		return severity;
	}
	
	public interactionConcept[] getinteractionConcept()
	{
		return interactionConcept;
	}
	
	
	public String toString()
	{
		return "\nInteraction Pair: "+interactionConcept[0] + " " + severity + " " + description;
	}

}
