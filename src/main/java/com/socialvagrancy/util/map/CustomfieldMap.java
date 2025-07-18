//===================================================================
// CustomfieldMap.java
//      Description:
//          This class handles methods around the customfield map
//          returned by the JQL search.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomfieldMap {
    private static final Logger log = LoggerFactory.getLogger(CustomfieldMap.class);

    public static Map<String, String> invert(Map<String, String> original) throws Exception {
        Map<String, String> converted = new HashMap<String, String>();
        String lowercaseKey;

        for(String key : original.keySet()) {
            lowercaseKey = original.get(key).toLowerCase(); // convert the value to lowercase.

            // Check for collisions
            if(converted.get(lowercaseKey) != null) {
                throw new Exception("[CLASH] Multiple field names exist for " + original.get(key) + ": " + converted.get(lowercaseKey) + ", " + key);
            } else {
                converted.put(lowercaseKey, key);
            }
        }

        return converted;
    }

    public static Map<String, String> filterResults(Map<String, String> original, List<String> filter) throws Exception {
        Map<String, String> converted = invert(original);
        Map<String, String> filtered = new HashMap<String, String>();

        for(String key : converted.keySet()) {
            if(filter.contains(key)) {
                filtered.put(key, converted.get(key));
            }
        }

        return filtered;
    }
}
