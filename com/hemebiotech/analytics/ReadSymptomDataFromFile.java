package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader, that read symptoms from given file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath));
            ) {
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier des symptômes. Veuillez vérifier l'emplacement du fichier");
            }

        }

        return result;
    }

}