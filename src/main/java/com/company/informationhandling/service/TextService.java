package com.company.informationhandling.service;

import com.company.informationhandling.composite.Component;

import javax.naming.OperationNotSupportedException;

public interface TextService {
    long countVowels(Component component) throws OperationNotSupportedException;
    String sortParagraphs(Component component) throws OperationNotSupportedException;
    String sentenceWithLongestWord(Component component)throws OperationNotSupportedException;
    String deleteSentenceByNumber(Component component,int limit)throws OperationNotSupportedException;
}
