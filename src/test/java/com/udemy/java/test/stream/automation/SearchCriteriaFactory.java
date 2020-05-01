package com.udemy.java.test.stream.automation;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchCriteriaFactory {


    private static Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
    private static Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
    private static Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    private static Predicate<List<WebElement>> hasUSA = (l) -> l.get(2).getText().equalsIgnoreCase("usa");
    private static Predicate<List<WebElement>> allFemaleUSA = allFemale.and(hasUSA);

    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static{
        MAP.put("allMale",allMale);
        MAP.put("allFemale",allFemale);
        MAP.put("allGender",allGender);
        MAP.put("hasUSA",hasUSA);
        MAP.put("allFemaleUSA",allFemaleUSA);

    }

    public static Predicate<List<WebElement>> getCriteria(String criteriaName){
        return MAP.get(criteriaName);
    }
}
