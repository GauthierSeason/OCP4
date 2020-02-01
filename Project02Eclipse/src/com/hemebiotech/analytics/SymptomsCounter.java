package com.hemebiotech.analytics;

/**
 * Simple brute force implementation
 *
 */

public class SymptomsCounter 
{
        public static void main(String []args)
        {
                try 
                {
                        AnalyticsCounter counter = new AnalyticsCounter();
                        counter.reader();
                        counter.symptomsMap();
                        counter.writer();
                        
                } catch (Exception e) {
                        System.out.println("Un problème a été détecté :" + e);
			System.exit(-1);
                }
                
	}
}