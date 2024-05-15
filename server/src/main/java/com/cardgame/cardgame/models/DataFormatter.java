package com.cardgame.cardgame.models;

import java.util.HashMap;
import java.util.Map;

public class DataFormatter {
    public static Map<String, Object> formatUsersDetails(String username, Double money) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("username", username);
        userDetails.put("money", money);
        return userDetails;
    }
}
