package com.company.informationhandling.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component{
    private final static String mark="Composite";
    private List<Component> components=new ArrayList<>();

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public boolean addComponent(Component component) {
        return components.add(component);
    }

    @Override
    public boolean removeComponent(Component component) {
        return components.remove(component);
    }
}
