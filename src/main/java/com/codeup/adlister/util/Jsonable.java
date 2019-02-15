package com.codeup.adlister.util;

public interface Jsonable {

    // Enforces the behavior that data objects ought to be readable as .json
    public String toJSON();
}
