package com.lcgm.api.automation.utils;

public enum Endpoints {
	
	GET_PRODUCTS("/{number}"),
    CREATE_PRODUCTS("/"),
    GET_ALL_PRODUCTS("/"),
    DELETE_PRODUCTS("/{number}"),
    UPDATE_PRODUCTS("/{number}");
	
    private final String path;

    Endpoints(String path) {
        this.path = path;
    }
    public String path() {
        return path;
    }

}
