package com.company.informationhandling.composite;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Text implements Component{
    private final static String mark="Text";
    private String text;

    public Text(String text) {
        this.text = text;
    }


    public String getMark() {
        return mark;
    }

    public String getText() {
        return text;
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

    public void setText(String text) {
        this.text = text;
    }
}
