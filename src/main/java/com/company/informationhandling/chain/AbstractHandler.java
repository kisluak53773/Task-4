package com.company.informationhandling.chain;

import com.company.informationhandling.composite.Component;

import javax.naming.OperationNotSupportedException;

public abstract class AbstractHandler {
    public abstract Component handleRequest(Component component) throws OperationNotSupportedException;
}
