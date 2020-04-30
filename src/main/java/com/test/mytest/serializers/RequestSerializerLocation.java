/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mytest.model.Location;

/**
 *
 * @author augustobatz
 */
public class RequestSerializerLocation {

    @JsonProperty
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
