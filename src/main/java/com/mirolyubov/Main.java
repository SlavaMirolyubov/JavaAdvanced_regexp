package com.mirolyubov;

import org.apache.log4j.Logger;
import java.io.*;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String temporaryString;
        String fileOriginal = "./src/main/resources/original.txt";
        String fileModified = "./src/main/resources/modified.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOriginal));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileModified))) {
            while ((temporaryString = bufferedReader.readLine()) != null) {
                bufferedWriter.write(Formater.formatNumbers(temporaryString));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found!");
        }
    }
}
