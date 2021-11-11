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
        TextComposite composite=new TextComposite();
        ParagraphParser parser=new ParagraphParser();
        ClassLoader loader= Main.class.getClassLoader();
        FileReader reader=new FileReader();
        TextServiceImplementation service=new TextServiceImplementation();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
        Component result=parser.handleRequest(composite);
        String expected="It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\n" +
                " Bye бандерлоги.\n" +
                "\n" +
                "  It has survived - not only (five) centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\n" +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\n" +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\n" +
                "versions of Lorem Ipsum!\n" +
                "\n" +
                " It is a long a!=b established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\n" +
                "content here's, making it look like readable English?";
        String actual=service.sortParagraphs(result);
        assertEquals(actual,expected);
    }

    @Test
    public void testSentenceWithLongestWord() throws URISyntaxException, OperationNotSupportedException{
        TextComposite composite=new TextComposite();
        ParagraphParser parser=new ParagraphParser();
        ClassLoader loader= Main.class.getClassLoader();
        FileReader reader=new FileReader();
        TextServiceImplementation service=new TextServiceImplementation();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
        Component result=parser.handleRequest(composite);
        String expected="The point of using Ipsum is that it has a\n" +
                "moreorless normal distribution ob.toStringa?b:c as opposed to using Content here\n" +
                "content here's making it look like readable English?";
        String actual=service.sentenceWithLongestWord(result);
        assertEquals(actual,expected);
    }

    @Test
    public void testDeleteSentenceByNumber()throws URISyntaxException, OperationNotSupportedException{
        TextComposite composite=new TextComposite();
        ParagraphParser parser=new ParagraphParser();
        ClassLoader loader= Main.class.getClassLoader();
        FileReader reader=new FileReader();
        TextServiceImplementation service=new TextServiceImplementation();
        Text text=new Text(reader.Read(loader.getResource("data/data.txt").toURI()));
        composite.addComponent(text);
        Component result=parser.handleRequest(composite);
        String expected="It has survived - not only (five) centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged It was popularised in the “Динамо” (Рига)\n" +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\n" +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\n" +
                "versions of Lorem Ipsum!\n" +
                "\n" +
                "  It is a long a!=b established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\n" +
                "content here's, making it look like readable English?\n" +
                "\n" +
                "  It is a established fact that a reader will be of a page when looking at its layout...";
        String actual=service.deleteSentenceByNumber(result,3);
        assertEquals(actual,expected);
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