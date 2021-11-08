package com.company.informationhandling.main;

import com.company.informationhandling.chain.ParagraphParser;
import com.company.informationhandling.chain.SentenceParser;
import com.company.informationhandling.composite.Sentence;
import com.company.informationhandling.composite.Text;
import com.company.informationhandling.composite.TextComposite;
import com.company.informationhandling.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    private final static Logger logger= LogManager.getLogger();
    public static void main(String[] args) throws URISyntaxException, OperationNotSupportedException {
        TextComposite composite=new TextComposite();
        SentenceParser parser=new SentenceParser();
        ClassLoader loader=Main.class.getClassLoader();
        FileReader reader=new FileReader();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
    }
}
