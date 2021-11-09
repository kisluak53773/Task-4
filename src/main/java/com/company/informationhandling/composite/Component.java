package com.company.informationhandling.composite;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface Component {
    List<Component> getComponents() throws OperationNotSupportedException;
    boolean addComponent(Component component) throws OperationNotSupportedException;
    boolean removeComponent(Component component) throws OperationNotSupportedException;
    String getMark();
}
