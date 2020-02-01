package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Object that can read, count and order, and write a symptom list.
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
	 * Read the symptoms from a file.
	 *
	 */
	public void reader() throws Exception 
	{
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		listSymptoms = reader.getSymptoms();
	}

	/**
	 * Count and order a symptom list.
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
	 * Write a symptom and occurrence map to a file.
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