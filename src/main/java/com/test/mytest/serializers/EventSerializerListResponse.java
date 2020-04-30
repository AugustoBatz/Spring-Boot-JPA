/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

import java.util.List;

/**
 *
 * @author augustobatz
 */
public class EventSerializerListResponse {

    private String response;

    private List<EventsLocation> events;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<EventsLocation> getEvents() {
        return events;
    }

    public void setEvents(List<EventsLocation> events) {
        this.events = events;
    }
}
