package com.example.floatingtest;

public class interactionConcept {
	private minConceptItem minConceptItem;
	private sourceConceptItem sourceConceptItem;
	
	public minConceptItem getMinConceptItem()
	{
		return minConceptItem;
	}
	
	public sourceConceptItem getSourceConceptItem()
	{
		return sourceConceptItem;
	}
	
	public String toString()
	{
		return "\nInteraction Concept" + minConceptItem.toString() + "\n" + sourceConceptItem.toString();
	}
}
