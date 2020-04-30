/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.resource;

import com.test.mytest.repository.LocationRepository;
import com.test.mytest.serializers.LocationSerializerRequest;
import com.test.mytest.serializers.LocationSerializerResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author augustobatz
 */
@RestController
@RequestMapping(value = "/localidad")
public class LocationResource {

    @Autowired
    private LocationRepository localRepo;

    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "POST LOCATION",
            description = "Crear nueva localidad")
    public LocationSerializerResponse insetLocation(@RequestBody final LocationSerializerRequest location) {
        localRepo.save(location.getRequest().getLocation());
        final LocationSerializerResponse lsp = new LocationSerializerResponse();
        lsp.setResponse("ok");
        lsp.setLocation(location.getRequest().getLocation());
        return lsp;
    }
}
