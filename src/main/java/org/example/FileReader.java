package org.example;

import java.io.IOException;
import java.io.InputStream;

public class FileReader {
    public static String getDataFromFile(String fileName) {
        InputStream fileStream = GraphBuilder.class.getResourceAsStream(fileName);
        try {
            byte[] fileBytes = fileStream.readAllBytes();
            return new String(fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
