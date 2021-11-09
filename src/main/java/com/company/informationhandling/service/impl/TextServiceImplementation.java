package com.company.informationhandling.service.impl;

import com.company.informationhandling.composite.Component;
import com.company.informationhandling.composite.Paragraph;
import com.company.informationhandling.composite.Text;
import com.company.informationhandling.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class TextServiceImplementation implements TextService {
    private final static String VOWELS_REGEX="aeiouAEIOUаеёиоуюяэыАЕЁИОУЮЯЭЫ";
    private final static String PARAGRAPHS_DELIMITER="[!.?] \\t*";

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
            sb.append(buffer.getParagraph()).append("\n\n ");
        }
        return sb.toString();
    }


}
