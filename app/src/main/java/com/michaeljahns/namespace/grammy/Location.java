package com.michaeljahns.namespace.grammy;

public class Location {

    private String name;

    public Location() {
    }

    public Location(String locationName) {
        this.name = locationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
