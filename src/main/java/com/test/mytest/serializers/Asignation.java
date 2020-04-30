/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

/**
 *
 * @author augustobatz
 */
public class Asignation {

    private EventSerializer event;

    private Location location;

    public EventSerializer getEvent() {
        return event;
    }

    public void setEvent(EventSerializer event) {
        this.event = event;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
