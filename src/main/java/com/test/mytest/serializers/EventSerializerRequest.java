/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.serializers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author augustobatz
 */
public class EventSerializerRequest {

    @JsonProperty
    private RequestSerializerEvent request;

    public RequestSerializerEvent getRequest() {
        return request;
    }

    public void setRequest(RequestSerializerEvent request) {
        this.request = request;
    }
}
