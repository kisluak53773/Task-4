package com.company.informationhandling.service;

import com.company.informationhandling.composite.Component;

import javax.naming.OperationNotSupportedException;

public interface TextService {
    long countVowels(Component component) throws OperationNotSupportedException;
    String sortParagraphs(Component component) throws OperationNotSupportedException;
}
