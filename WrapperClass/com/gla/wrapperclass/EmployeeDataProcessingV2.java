package com.gla.wrapperclass;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDataProcessingV2 {
    public static void main(String[] args) {
        int[] ages = {42, 31, 27, 53, 24, 38, 46, 29};

        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(Integer.valueOf(age));
        }

        System.out.println("All Employee Ages: " + ageList);

        Integer youngest = Collections.min(ageList);
        Integer oldest = Collections.max(ageList);

        System.out.println("Youngest Employee: " + youngest + " years");
        System.out.println("Oldest Employee: " + oldest + " years");
    }
}
