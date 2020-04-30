/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mytest.model.Event;

/**
 *
 * @author augustobatz
 */
public class RequestSerializerEvent {

    @JsonProperty
    private Event evento;

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }
}
