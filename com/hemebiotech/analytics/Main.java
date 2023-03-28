package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

class Main {

    /**
     * Instantiate an AnalyticsCounter with ReadSymptomDataFromFile and WriteSymptomDataToFile,
     * then first get symptoms, count symptoms, sort them, and finally write them.
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> countSymptoms = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countSymptoms);
        counter.writeSymptoms(sortedSymptoms);
    }

}