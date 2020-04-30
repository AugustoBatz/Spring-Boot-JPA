/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

import com.test.mytest.model.Event;
import com.test.mytest.model.Location;
import java.util.List;

/**
 *
 * @author augustobatz
 */
public class EventsLocation {

    private String name;

    private String place;

    private List<Location> locations;

    public EventsLocation(Event event) {
        this.name = event.getName();
        this.name = event.getPlace();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
