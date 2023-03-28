package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter read, sort and write symptoms.
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Initialize reader and writer.
     * @param reader file read stream
     * @param writer file write stream
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Get symptoms from reader.
     * @return list of strings
     */
    public List<String> getSymptoms() {
        return this.reader.getSymptoms();
    }

    /**
     * Takes a list of symptoms and transforms it to a map of symptom as key and occurrence as value.
     * Example list of [fever, cough, fever] -> [ fever -> 2 , cough -> 1].
     * @param symptoms list of symptoms
     * @return  a map where the key is a symptom and the value is a number of occurrence
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String symptom : symptoms) {

            if (!occurrences.containsKey(symptom)) {
                occurrences.put(symptom, 1);
            } else {
                occurrences.put(symptom, occurrences.get(symptom) + 1);
            }

        }
        return occurrences;
    }

    /**
     * Alphabetic sort given map of symptoms and occurrences.
     * @param symptoms in a map
     * @return alphabetic sorted given symptoms
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Write symptoms to writer.
     * @param symptoms in a map
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.writer.writeSymptoms(symptoms);
    }

}