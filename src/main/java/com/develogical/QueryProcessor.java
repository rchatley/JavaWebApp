package com.develogical;

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

    public String findSum(String str) {
        String[] numbers = str.split(",");
        return String.valueOf(Integer.parseInt(numbers[0].trim()) + Integer.parseInt(numbers[1].trim()));
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
//        if (query.toLowerCase().contains("plus")) {
//            return findSum(query.substring(query.indexOf("is"), query.indexOf("plus"))
//        }
        return "";
    }
}
