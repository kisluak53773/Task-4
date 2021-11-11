package com.company.informationhandling.chain;

import com.company.informationhandling.composite.Component;
import com.company.informationhandling.composite.Sentence;
import com.company.informationhandling.composite.Word;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class WordParser extends AbstractHandler{
    private static final String WORD_DELIMITER="\\s";
    private static final String PUNCTUATION_REGEX="[),(-]";
    private static final String END_PUNCTUATION="[!.?]";

    @Override
    public Component handleRequest(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        List<Component> sortedComponents=new ArrayList<>();
        for (Component object:components){
            if(object.getMark()=="Sentence"){
                sortedComponents.add(object);
            }
        }
        for(Component object:sortedComponents){
            Sentence sentence=(Sentence) object;
            String buffer=sentence.getSentence().replaceAll(PUNCTUATION_REGEX,"");
            String[]words=buffer.split(WORD_DELIMITER);
            words[words.length-1]=words[words.length-1].replaceAll(END_PUNCTUATION,"");
            for(String str:words){
                if(str!="") {
                    component.addComponent(new Word(str));
                }
            }
        }
        return component;
    }
}
