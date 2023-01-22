package com.lcgm.api.automation.utils;

import java.util.Optional;

public class GetEnvironment {

    private GetEnvironment() {
        throw new IllegalStateException("Utility class");
    }

    public static String actual() {
        return Optional.ofNullable(System.getProperty("environment"))
                .orElseThrow(() ->
                        new IllegalArgumentException("You need to specify the variable: [environment]"));
    }
}
