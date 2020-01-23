package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class AnalyticsCounter {

	public AnalyticsCounter() {
	 }

	List<String> list_symptoms = new ArrayList<String>();
	TreeMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(); 

	public void Counter() throws Exception {
		// first get input
		ReadSymptomDataFromFile Reader = new ReadSymptomDataFromFile("symptoms.txt");
		list_symptoms = Reader.GetSymptoms();
	}

	public void SymptomsMap() throws Exception {
		
		for (String lvSymptom : list_symptoms) {

			int count = sortedSymptoms.containsKey(lvSymptom) ? sortedSymptoms.get(lvSymptom) : 0;
			sortedSymptoms.put(lvSymptom, count + 1);

		}
	}
		// next generate output

		public void Writer() throws Exception {
			FileWriter writer = new FileWriter ("result.out");

			for(Map.Entry<String,Integer> entry : sortedSymptoms.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
			  
				writer.write(key + " : " + value + "\n");
			  }
			writer.close();
		}
	
}
