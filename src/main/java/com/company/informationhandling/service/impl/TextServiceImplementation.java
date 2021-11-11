package com.company.informationhandling.service.impl;

import com.company.informationhandling.composite.*;
import com.company.informationhandling.service.TextService;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextServiceImplementation implements TextService {
    private static final String VOWELS_REGEX="aeiouAEIOUаеёиоуюяэыАЕЁИОУЮЯЭЫ";
    private static final String PARAGRAPHS_DELIMITER="[!.?] \\t*";
    private static final String WORD_DELIMITER="\\s";
    private static final String WORD_DELIMITER2="\\s\\b";
    private static final String PUNCTUATION_REGEX="[),(-]";
    private static final String END_PUNCTUATION="[!.?]";

    @Override
    public long countVowels(Component component) throws OperationNotSupportedException {
        List<Component> list=component.getComponents();
        Text textComponent=(Text) list.get(0);
        String text=textComponent.getText();
        return text.chars().mapToObj(o->(char)o).filter(c->VOWELS_REGEX.contains(String.valueOf(c))).count();
    }

    @Override
    public String sortParagraphs(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        List<Component> sortedComponents=new ArrayList<>();
        for(Component a:components){
            if(a.getMark().equals("Paragraph")){
                sortedComponents.add(a);
            }
        }
        boolean iterator=true;
        while (iterator){
            iterator=false;
            for(int i=1;i<sortedComponents.size();i++){
                Paragraph paragraph1=(Paragraph) sortedComponents.get(i);
                Paragraph paragraph2=(Paragraph) sortedComponents.get(i-1);
                if(paragraph1.getParagraph().split(PARAGRAPHS_DELIMITER).length<paragraph2.getParagraph().split(PARAGRAPHS_DELIMITER).length){
                    sortedComponents.remove(i);
                    sortedComponents.add(i,paragraph2);
                    sortedComponents.remove(i-1);
                    sortedComponents.add(i-1,paragraph1);
                    iterator=true;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Component a:sortedComponents){
            Paragraph buffer=(Paragraph)a;
            sb.append(buffer.getParagraph()).append("\n ");
        }
        return sb.toString().trim().replaceAll("\\r","");
    }

    @Override
    public String sentenceWithLongestWord(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        List<Component> sortedComponents=new ArrayList<>();
        String longestSentence = null;
        int max=0;
        for (Component object:components){
            if(object.getMark().equals("Sentence")){
                sortedComponents.add(object);
            }
        }
        for(Component object:sortedComponents) {
            Sentence sentence = (Sentence) object;
            String buffer = sentence.getSentence().replaceAll(PUNCTUATION_REGEX, "");
            String[] words = buffer.split(WORD_DELIMITER);
            words[words.length - 1] = words[words.length - 1].replaceAll(END_PUNCTUATION, "");
            for(String str:words){
                if(str.length()>max){
                    max=str.length();
                    longestSentence=buffer;
                }
            }
        }
        return longestSentence.trim();
    }

    @Override
    public String deleteSentenceByNumber(Component component,int limit) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        List<Component> sortedComponents=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(Component object:components){
            if(object.getMark().equals("Paragraph")){
                sortedComponents.add(object);
            }
        }
        for(Component object:sortedComponents){
            Paragraph paragraph=(Paragraph) object;
            String[] sentences=paragraph.getParagraph().split(PARAGRAPHS_DELIMITER);
            for(String str:sentences){
                sb.append("\s");
                String[] words=str.split(WORD_DELIMITER2);
                if(words.length>=limit){
                    sb.append(str);
                }
            }
            sb.append("\n ");
        }
        return sb.toString().trim();
    }

    @Override
    public int countEqualStrings(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        List<Component> sortedComponents=new ArrayList<>();
        List<String> words=new ArrayList<>();
        for(Component a:components){
            if(a.getMark().equals("Word")){
                sortedComponents.add(a);
            }
        }
        for(Component object:sortedComponents){
            Word word=(Word)object;
            words.add(word.getWord().toLowerCase());
        }
        int count=0;
        for(String str:words){
            count+= Collections.frequency(words, str);
        }
        return count;
    }
}
