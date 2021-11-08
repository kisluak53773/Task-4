package com.company.informationhandling.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class FileReader {
    private final static Logger logger= LogManager.getLogger();
    public String Read(URI path) {
        File file=new File(path);
        StringBuilder sb=new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        try (java.io.FileReader reader=new java.io.FileReader(file);
             BufferedReader bufferedReader=new BufferedReader(reader))
        {
            while( ( line = bufferedReader.readLine() ) != null ) {
                sb.append( line );
                sb.append(ls);
            }
        } catch (IOException e) {
            logger.error("IO Exception");
        }
        return sb.toString();
    }
}
