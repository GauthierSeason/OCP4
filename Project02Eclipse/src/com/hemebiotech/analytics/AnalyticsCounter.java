package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * TO DO
 *
 */
public class AnalyticsCounter 
{

	public AnalyticsCounter() 
	{
	}

	private List<String> listSymptoms = new ArrayList<String>();
	private TreeMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(); 

	/**
	 * Simple brute force implementation
	 *
	 */
	public void reader() throws Exception 
	{
		// first get input
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		listSymptoms = reader.getSymptoms();
	}

	/**
	 * Simple brute force implementation
	 *
	 */
	public void symptomsMap() throws Exception 
	{
		for (String lvSymptom : listSymptoms) 
		{
			int count = sortedSymptoms.containsKey(lvSymptom) ? sortedSymptoms.get(lvSymptom) : 0;
			sortedSymptoms.put(lvSymptom, count + 1);
		}
	}
		
	/**
	 * Simple brute force implementation
	 *
	 */
	public void writer() throws Exception 
	{
		FileWriter writer = new FileWriter ("result.out");
		for (Map.Entry<String,Integer> entry : sortedSymptoms.entrySet()) 
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
			writer.write(key + " : " + value + "\n");
		}
		writer.close();
	}	
}