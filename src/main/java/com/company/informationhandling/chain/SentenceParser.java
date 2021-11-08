package com.company.informationhandling.chain;

import com.company.informationhandling.composite.Component;
import com.company.informationhandling.composite.Sentence;
import com.company.informationhandling.composite.Text;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class SentenceParser extends AbstractHandler{
    private final static String SENTENCE_REGEX="[!.?\\n] \\t*";
    @Override
    public Component handleRequest(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        Text text=(Text)components.get(0);
        String[] sentences=text.getText().split(SENTENCE_REGEX);
        for (String object:sentences){
            component.addComponent(new Sentence(object));
        }
        return component;
    }
}
