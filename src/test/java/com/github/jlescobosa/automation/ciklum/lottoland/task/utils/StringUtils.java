package com.github.jlescobosa.automation.ciklum.lottoland.task.utils;

import java.util.ArrayList;

public class StringUtils {

    public static ArrayList<String> removeMiddleNames(ArrayList<String> userList) {
        ArrayList<String> output = new ArrayList<>();
        for (String fullName : userList) {
            String firstName = fullName.split(" ")[0];
            String lastName = fullName.substring(fullName.lastIndexOf(" ") + 1);
            output.add(firstName + " " + lastName);
        }
        return output;
    }
}
