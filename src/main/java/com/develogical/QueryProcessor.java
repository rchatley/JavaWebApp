package com.develogical;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryProcessor {

    public String findLargest(String str) {
        String[] numbers = str.split(",");

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.parseInt(numbers[i].trim()));
        }
        return String.valueOf(Collections.max(list));
    }

    public  String doMath(String str, int i, int j) {
        String temp = "";
        switch (str) {
            case "plus": temp = String.valueOf(i + j);
            break;
            case "multiplied": temp =  String.valueOf(i * j);
            break;
            default : break;
        }
        return temp;
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "PriyaDiella";
        }

        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            return findLargest(query.split("largest:")[1]);
        }
        if (query.toLowerCase().contains("plus")) {
            String[] temp = StringUtils.substringAfter(query, "what is ").split(" ");
            for (String a: temp
                 ) {
                System.out.println(a);
            }
            return doMath(temp[1], Integer.parseInt(temp[0]), Integer.parseInt(temp[2]));
        }
        if (query.toLowerCase().contains("multiplied")) {
            String[] temp = StringUtils.substringAfter(query, "what is ").split(" ");
            for (String a: temp
            ) {
                System.out.println(a);
            }
            return doMath(temp[1], Integer.parseInt(temp[0]), Integer.parseInt(temp[3]));
        }
        return "";
    }
}
