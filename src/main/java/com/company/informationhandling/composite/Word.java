package com.company.informationhandling.composite;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Word implements Component {
    private final static String mark="Word";
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public List<Component> getComponents() throws OperationNotSupportedException {
        throw  new OperationNotSupportedException("Leaf doesn't support this operation");
    }

    @Override
    public boolean addComponent(Component component) throws OperationNotSupportedException {
        return false;
    }

    @Override
    public boolean removeComponent(Component component) throws OperationNotSupportedException {
        throw  new OperationNotSupportedException("Leaf doesn't support this operation");
    }

    @Override
    public String getMark() {
        return mark;
    }

    public String getWord() {
        return word;
    }
}
