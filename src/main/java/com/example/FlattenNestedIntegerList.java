package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
4. Flatten Nested Collections
Problem Statement: Given a List<List<Integer>>, return a sorted list of unique integers.

Constraints:

Remove duplicates
Result should be sorted in ascending order
Use Stream API only

 */
public class FlattenNestedIntegerList {
    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(new Integer[]{1,3,5,8,7 ,9});
        List<Integer> num2 = Arrays.asList(new Integer[]{2,4,6,8,10});

        List<List<Integer>> input = new ArrayList<>();
        input.add(num1);
        input.add(num2);

        List<Integer> result = input.stream().flatMap(List::stream).distinct().sorted().toList();
        System.out.println(result);
    }
}
