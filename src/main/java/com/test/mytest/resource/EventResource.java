/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.resource;

import com.test.mytest.model.Event;
import com.test.mytest.repository.EventRespository;
import com.test.mytest.serializers.EventSerializerListResponse;
import com.test.mytest.serializers.EventSerializerRequest;
import com.test.mytest.serializers.EventSerializerResponse;
import com.test.mytest.serializers.EventsLocation;
import io.swagger.v3.oas.annotations.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author augustobatz
 */
@RestController
@RequestMapping(value = "/evento")
public class EventResource {

    @Autowired
    private EventRespository eventrepo;

    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "POST EVENT",
            description = "Crear nuevo evento")
    public EventSerializerResponse insertEvent(@RequestBody final EventSerializerRequest event) {
        final EventSerializerResponse es = new EventSerializerResponse();
        eventrepo.save(event.getRequest().getEvento());
        es.setResponse("ok");
        es.setEvent(event.getRequest().getEvento());
        return es;
    }

    @RequestMapping(
            value = "/lista",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "GET Events",
            description = "Lista de eventos con localidad")
    public EventSerializerListResponse getEvents() {
        final EventSerializerListResponse eslp = new EventSerializerListResponse();
        final List<EventsLocation> eventsLocation = new ArrayList<>();
        List<Event> listEvent = eventrepo.findAll();
        listEvent.stream().forEach((c) -> {
            EventsLocation el = new EventsLocation(c);
            //el.setLocalidades(locationRepo.getLocationsByIDEvent(c.getId()));
            eventsLocation.add(el);

        });
        eslp.setResponse("ok");
        eslp.setEvents(listEvent);
        return eslp;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "GET Event",
            description = "Obtener un evento en especifico")
    public Event getEvent(@PathVariable("id") Integer id) {
        final Optional<Event> event = eventrepo.findById(id);
        return event.get();
    }
}
