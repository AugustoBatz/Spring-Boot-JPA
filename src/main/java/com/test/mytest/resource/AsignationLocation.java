/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.resource;

import com.test.mytest.model.Event;
import com.test.mytest.model.Location;
import com.test.mytest.repository.EventRespository;
import com.test.mytest.repository.LocationRepository;
import com.test.mytest.serializers.EventLocation;
import com.test.mytest.serializers.Response;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author augustobatz
 */
@RestController
@RequestMapping(value = "")
public class AsignationLocation {

    @Autowired
    private EventRespository eventrepo;

    @Autowired
    private LocationRepository locationRepo;

    @RequestMapping(
            value = "/asignar",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "POST Location and Event",
            description = "Asigna una localidad a un evento")
    public Response asignarLocalidad(@RequestBody final EventLocation eventLocation) {
        final Integer location = eventLocation.getRequest().getLocation().getId();
        final Integer event = eventLocation.getRequest().getEvent().getId();
        Optional<Event> eventFind = eventrepo.findById(event);
        Optional<Location> locationFind = locationRepo.findById(location);
        if (!locationFind.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "this location not found");
        }
        if (!eventFind.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "this event not found");
        }
        final Event updateEvent = eventFind.get();
        updateEvent.addLocation(locationFind.get());
        eventrepo.save(updateEvent);
        final Response response = new Response();
        response.setResponse("ok");
        return response;
    }
}
