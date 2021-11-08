package com.company.informationhandling.composite;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Sentence implements Component{
    private final static String mark="Sentence";
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public static String getMark() {
        return mark;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public List<Component> getComponents() throws OperationNotSupportedException {
        throw  new OperationNotSupportedException("Leaf doesn't support this operation");
    }

    @Override
    public boolean addComponent(Component component) throws OperationNotSupportedException {
        throw  new OperationNotSupportedException("Leaf doesn't support this operation");
    }

    @Override
    public boolean removeComponent(Component component) throws OperationNotSupportedException {
        throw  new OperationNotSupportedException("Leaf doesn't support this operation");
    }
}
