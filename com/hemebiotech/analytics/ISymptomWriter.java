package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Anything the will write symptom data on a valid data output format
 */
public interface ISymptomWriter {

    /**
     * Write symptoms to a target output.
     * @param symptoms map of symptom as key and counter of occurrence as value example fever : 2
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
