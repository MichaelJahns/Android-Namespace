package com.michaeljahns.namespace.grammy;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class PirateLocation implements Jsonable {
    private String location;

    public PirateLocation(){

    }

    public PirateLocation(String location){
        this.location = location;
    }
    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("location", this.location);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try{
            writable.write(this.toJson());
        }catch (Exception ignored){
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
