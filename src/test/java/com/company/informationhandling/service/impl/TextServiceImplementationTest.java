package com.company.informationhandling.service.impl;

import com.company.informationhandling.chain.ParagraphParser;
import com.company.informationhandling.composite.Component;
import com.company.informationhandling.composite.Text;
import com.company.informationhandling.composite.TextComposite;
import com.company.informationhandling.main.Main;
import com.company.informationhandling.reader.FileReader;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.net.URISyntaxException;

import static org.testng.Assert.*;

public class TextServiceImplementationTest {

    @Test
    public void testCountVowels()throws URISyntaxException, OperationNotSupportedException {
        TextComposite composite=new TextComposite();
        ParagraphParser parser=new ParagraphParser();
        ClassLoader loader= Main.class.getClassLoader();
        FileReader reader=new FileReader();
        TextServiceImplementation service=new TextServiceImplementation();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
        Component result=parser.handleRequest(composite);
        long expected=242;
        long actual=service.countVowels(result);
        assertEquals(actual,expected);
    }

    @Test
    public void testSortParagraphs()throws URISyntaxException, OperationNotSupportedException {
    }

    @Test
    public void testSentenceWithLongestWord() throws URISyntaxException, OperationNotSupportedException{
    }

    @Test
    public void testDeleteSentenceByNumber()throws URISyntaxException, OperationNotSupportedException{
    }

    @Test
    public void testCountEqualStrings()throws URISyntaxException, OperationNotSupportedException {
        TextComposite composite=new TextComposite();
        ParagraphParser parser=new ParagraphParser();
        ClassLoader loader= Main.class.getClassLoader();
        FileReader reader=new FileReader();
        TextServiceImplementation service=new TextServiceImplementation();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
        Component result=parser.handleRequest(composite);
        int expected=293;
        int actual=service.countEqualStrings(result);
        assertEquals(actual,expected);
    }
}