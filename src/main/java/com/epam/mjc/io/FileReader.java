package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        BufferedReader br = null;
        String[] card = new String[4];
        try {
            String line;
            int i = 0;
            br = new BufferedReader(new java.io.FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] text = line.split(": ");
                card[i] = text[1];
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new Profile(card[0], Integer.valueOf(card[1]), card[2], Long.valueOf(card[3]));
    }
}



