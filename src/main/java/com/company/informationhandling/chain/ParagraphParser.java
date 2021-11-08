package com.company.informationhandling.chain;

import com.company.informationhandling.composite.Component;
import com.company.informationhandling.composite.Paragraph;
import com.company.informationhandling.composite.Text;
import com.company.informationhandling.composite.TextComposite;


import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ParagraphParser extends AbstractHandler{
    private static final String PARAGRAPH_REGEX="\n ";
    private SentenceParser successor=new SentenceParser();

    @Override
    public Component handleRequest(Component component) throws OperationNotSupportedException {
        List<Component> components=component.getComponents();
        Text text=(Text)components.get(0);
        String[] paragraphs=text.getText().split(PARAGRAPH_REGEX);
        for (String object:paragraphs){
            component.addComponent(new Paragraph(object));
        }
        return successor.handleRequest(component);
    }
}
