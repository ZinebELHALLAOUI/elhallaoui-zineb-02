package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter("result.out");
            for (Map.Entry<String, Integer> symptomAndCounter : symptoms.entrySet()) {
                writer.write(symptomAndCounter.getKey() + " : " + symptomAndCounter.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}