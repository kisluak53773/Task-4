package com.company.informationhandling.composite;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Paragraph implements Component{
    private final static String mark="Paragraph";
    private String paragraph;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public static String getMark() {
        return mark;
    }

    public String getParagraph() {
        return paragraph;
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
