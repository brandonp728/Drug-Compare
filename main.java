package com.example.drugcompare;

import java.util.*;
import java.io.*;
import java.net.*;
import com.google.gson.*;

public class main {
	
	public static void main(String[] args) throws Exception
	{
		HashMap<String, Integer> drugList = new HashMap<String, Integer>();
		drugList.put("Acetaminophen", 313820);
		drugList.put("Adderall", 1009145);
		drugList.put("Alprazolam", 197321);
		drugList.put("Caffeine", 198520);
		drugList.put("Marijuana", 197636);
		drugList.put("Nicotine", 314119);
		drugList.put("Hydrocodone", 856987);
		drugList.put("Fentanyl", 1603495);
		drugList.put("Diphenhydramine", 1020477);
		drugList.put("Dimenhydrinate", 198603);
		drugList.put("Cetirizine", 1011482);
		drugList.put("Psuedoephedrine", 998254);
		drugList.put("Codeine", 997272);
		
		//System.out.println(parseJSON(getHTML("https://rxnav.nlm.nih.gov/REST/RxTerms/rxcui/1011482/allinfo.json"), "allInfo"));
		drugRelationship dr = (drugRelationship)parseJSON(getHTML("https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=1011482&sources=DrugBank"), "drugRelation");
		System.out.println("Disclaimer: " + dr.getDisclaimer());
		System.out.println("RXCUI: " + dr.getUserInput().getRXCUI());
		System.out.println("Source: " + dr.getUserInput().getSources()[0]);
		interactionTypeGroup[] i = dr.getTypeGroup();
		System.out.println("Source Disclaimer: " + i[0].getSourceDisclaimer());
		System.out.println("Source Name: " + i[0].getSourceName());
		interactionType[] iT = i[0].getInteractionType();
		System.out.println("Comment: " + iT[0].getComment());
		System.out.println("Drug you're using: " + iT[0].getMinConceptItem().getName());
		System.out.println("RXCUI: " + iT[0].getMinConceptItem().getRXCUI());
		interactionPair[] p = iT[0].getInteractionPair();
		System.out.println("Severity of mixing: " + p[0].getSeverity());
		System.out.println("Description: " + p[0].getDescription());
		interactionConcept[] c = p[0].getinteractionConcept();
		System.out.println("Drug you're mixing: " + c[0].getMinConceptItem().getName());
		System.out.println("RXCUI: " + c[0].getMinConceptItem().getRXCUI());
		System.out.println("Other drug: " + c[1].getSourceConceptItem().getName());
		System.out.println("RXCUI: " + c[1].getSourceConceptItem().getID());
		
		
		
	}
	
	public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }
	
	public static Object parseJSON(String JSON, String type)
	{
		Gson g = new GsonBuilder().create();
		Object d = null;
		if(type.equalsIgnoreCase("allInfo"))
		{
			d = g.fromJson(JSON, drug.class);
		}
		else if(type.equalsIgnoreCase("drugRelation"))
		{
			d = g.fromJson(JSON, drugRelationship.class);
		}
		return d;
	}
}

