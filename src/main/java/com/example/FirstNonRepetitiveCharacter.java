package com.example;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 2. First Non-Repeating Character
 Problem Statement: Given a string input, find the first non-repeating character while preserving the original order.

 Constraints:

 Case-sensitive ('A' and 'a' are different)
 Return empty result if no such character exists
 */
public class FirstNonRepetitiveCharacter {
    public static void main(String[] args) {
        String name = "Saurabhshara";
        Character result = name.chars().mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get();


        System.out.println("Result: "+result);

    }
}
