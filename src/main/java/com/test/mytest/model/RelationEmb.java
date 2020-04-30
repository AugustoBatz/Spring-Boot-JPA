/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author augustobatz
 */
@Entity(name = "RelationEmb")
@Table(name = "locations")
public class RelationEmb {

    @EmbeddedId
    private RelationLocation id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventID")
    private Event post;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locationID")
    private Location tag;

}
